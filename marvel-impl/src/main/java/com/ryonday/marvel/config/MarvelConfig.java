package com.ryonday.marvel.config;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ryon on 2/21/14.
 */
public class MarvelConfig {

    private final static Logger LOG = LoggerFactory.getLogger( MarvelConfig.class );

    private final String publicKey;

    private final String privateKey;

    @Inject
    public MarvelConfig(@Named("marvel.endpoint") String endpoint,
                        @Named("marvel.key.public") String publicKey,
                        @Named("marvel.key.private") String privateKey,
                        @Named("marvel.useGzip") boolean useGzip) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarvelConfig other = (MarvelConfig) o;

        if (Objects.equal( this.privateKey, other.privateKey)) return false;
        if (Objects.equal( this.publicKey, other.privateKey )) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = publicKey.hashCode();
        result = 31 * result + privateKey.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("\n\tpublicKey", publicKey)
                .add("\n\tprivateKey", privateKey)
                //.add("superclass", super.toString().replaceAll("\n", "\n\t"))
                .addValue('\n')
                .toString();
    }
}
