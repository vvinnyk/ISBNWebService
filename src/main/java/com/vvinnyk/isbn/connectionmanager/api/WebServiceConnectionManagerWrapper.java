package com.vvinnyk.isbn.connectionmanager.api;

/**
 * WebServiceConnectionManagerWrapper to wrap WebServiceConnectionManager.
 * <p>
 * Can be used to introduce addition logic(e.g. Check if
 * entity present in Repository, if no request it from
 * remote Web Service.)
 *
 * @author Vladyslav_Vinnyk on 11/30/2016.
 */
public interface WebServiceConnectionManagerWrapper extends WebServiceConnectionManager {
}
