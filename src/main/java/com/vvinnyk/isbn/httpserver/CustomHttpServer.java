package com.vvinnyk.isbn.httpserver;


import com.vvinnyk.isbn.Properties;
import com.vvinnyk.isbn.rest.api.BookRestController;
import com.vvinnyk.isbn.rest.impl.BookRestControllerImpl;
import com.sun.net.httpserver.Authenticator;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpPrincipal;
import com.sun.net.httpserver.HttpServer;
import com.vvinnyk.isbn.utils.Messages;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * @author Vladyslav_Vinnyk on 12/1/2016.
 */
public class CustomHttpServer {
    private static final Logger LOG = LoggerFactory.getLogger(Properties.LOGGER_NAME);

    private static final BookRestController bookRestController = new BookRestControllerImpl();

    public static void main(String[] args) throws Exception {
        LOG.debug(Messages.SERVER_IS_GOING_TO_START);

        HttpServer httpServer = HttpServer.create();
        httpServer.bind(new InetSocketAddress(Properties.HTTP_SERVER_PORT), 0);

        HttpContext context = httpServer.createContext("/", new EchoHandler());
        context.setAuthenticator(new Auth());

        httpServer.setExecutor(null);
        httpServer.start();

        LOG.debug(Messages.SERVER_IS_STARTED_AT_PORT, Properties.HTTP_SERVER_PORT);
    }

    static class EchoHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String json = EMPTY;
            String isbn = getBookIsbnFromQuery(exchange);
            if (isNotBlank(isbn)) {
                json = bookRestController.getBookAsJSON(isbn);
            }

            byte[] bytes = json.getBytes();
            exchange.sendResponseHeaders(200, bytes.length);

            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
        }

        private String getBookIsbnFromQuery(HttpExchange exchange) {
            URI requestURI = exchange.getRequestURI();
            List<NameValuePair> paramsList = URLEncodedUtils.parse(requestURI, "utf-8");

            for (NameValuePair parameter : paramsList) {
                if ("book".equals(parameter.getName())) {
                    return parameter.getValue();
                }
            }

            return EMPTY;
        }
    }

    static class Auth extends Authenticator {
        @Override
        public Result authenticate(HttpExchange httpExchange) {
            if ("/forbidden".equals(httpExchange.getRequestURI().toString()))
                return new Failure(403);
            else
                return new Success(new HttpPrincipal("c0nst", "realm"));
        }
    }

}