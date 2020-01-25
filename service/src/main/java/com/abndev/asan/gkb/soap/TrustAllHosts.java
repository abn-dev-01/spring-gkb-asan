package com.abndev.asan.gkb.soap;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class TrustAllHosts
        implements HostnameVerifier {
    public boolean verify(String hostname, SSLSession session) {
        return true;
    }
}

