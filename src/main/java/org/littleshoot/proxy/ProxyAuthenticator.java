package org.littleshoot.proxy;

import org.littleshoot.proxy.impl.ClientToProxyConnection;

import io.netty.handler.codec.http.HttpRequest;

/**
 * Interface for objects that can authenticate someone for using our Proxy on
 * the basis of a username and password.
 */
public interface ProxyAuthenticator {
    /**
     * Authenticates the user using the specified userName and password.
     * 
     * @param userName
     *            The user name.
     * @param password
     *            The password.
     * @param clientConnection
     *            The connection that this auth request came from.
     * @return <code>true</code> if the credentials are acceptable, otherwise
     *         <code>false</code>.
     */
    boolean authenticate(String userName, String password, ClientToProxyConnection clientConnection);
    
    /**
     * The realm value to be used in the request for proxy authentication 
     * ("Proxy-Authenticate" header). Returning null will cause the string
     * "Restricted Files" to be used by default.
     * 
     * @return
     */
    String getRealm();
    
    /**
     * Determine whether authentication is required for a particular request.
     * 
     * @param httpRequest
     * @return true if authentication is required or false if not
     */
    boolean isAuthenticationRequired(HttpRequest httpRequest);
}
