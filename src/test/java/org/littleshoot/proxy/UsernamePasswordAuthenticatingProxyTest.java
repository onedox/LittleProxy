package org.littleshoot.proxy;

import org.littleshoot.proxy.impl.ClientToProxyConnection;

import io.netty.handler.codec.http.HttpRequest;

/**
 * Tests a single proxy that requires username/password authentication.
 */
public class UsernamePasswordAuthenticatingProxyTest extends BaseProxyTest
        implements ProxyAuthenticator {
    @Override
    protected void setUp() {
        this.proxyServer = bootstrapProxy()
                .withPort(0)
                .withProxyAuthenticator(this)
                .start();
    }

    @Override
    protected String getUsername() {
        return "user1";
    }

    @Override
    protected String getPassword() {
        return "user2";
    }

    @Override
    public boolean authenticate(String userName, String password, ClientToProxyConnection clientConnection) {
        return getUsername().equals(userName) && getPassword().equals(password);
    }

    @Override
    protected boolean isAuthenticating() {
        return true;
    }

    @Override
    public String getRealm() {
        return null;
    }
    
    @Override
    public boolean isAuthenticationRequired(HttpRequest httpRequest) {
    	return true;
    }
}
