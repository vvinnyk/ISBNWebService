package com.vvinnyk.isbn.httpserver;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.vvinnyk.isbn.Properties;
import com.vvinnyk.isbn.rest.api.BookRestController;
import com.vvinnyk.isbn.rest.impl.BookRestControllerImpl;
import com.vvinnyk.isbn.utils.Messages;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Simple Http Server.
 *
 * @author Vladyslav_Vinnyk on 12/1/2016.
 */
public class CustomHttpServer {
    private static final Logger LOG = LoggerFactory.getLogger(Properties.LOGGER_NAME);

    private static final BookRestController bookRestController = new BookRestControllerImpl();

    public static void main(String[] args) throws Exception {
        LOG.debug(Messages.SERVER_IS_GOING_TO_START);

        HttpServer httpServer = HttpServer.create();
        httpServer.bind(new InetSocketAddress(Properties.HTTP_SERVER_PORT), 0);

        httpServer.createContext("/", new EchoHandler());

        httpServer.setExecutor(null);
        httpServer.start();

        LOG.debug(Messages.SERVER_IS_STARTED_AT_PORT, Properties.HTTP_SERVER_PORT);
        LOG.info(Messages.ADVICE_TO_USER, Properties.HTTP_SERVER_PORT);
    }

    static class EchoHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            String response = EMPTY;
            String bookIsbn = getBookIsbnFromQuery(httpExchange);
            if (isNotBlank(bookIsbn)) {
                try {
                    response = bookRestController.getBookAsJSON(bookIsbn);
                } catch (Exception e) {
                    response = e.getMessage();
                }
            }

            byte[] responseBytes = response.getBytes();
            httpExchange.sendResponseHeaders(200, responseBytes.length);

            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(responseBytes);
            outputStream.close();
        }

        private String getBookIsbnFromQuery(HttpExchange httpExchange) {
            URI requestURI = httpExchange.getRequestURI();
            List<NameValuePair> parameterList = URLEncodedUtils.parse(requestURI, StandardCharsets.UTF_8.toString());

            for (NameValuePair parameter : parameterList) {
                if ("book".equals(parameter.getName())) {
                    return parameter.getValue();
                }
            }
            return EMPTY;
        }
    }

}