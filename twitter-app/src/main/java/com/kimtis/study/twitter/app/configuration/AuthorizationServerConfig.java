package com.kimtis.study.twitter.app.configuration;

import com.kimtis.study.twitter.domain.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
@ComponentScan("com.kimtis.study.twitter.domain")
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private String resourceId="twitter-app";

    private int accessTokenValiditySeconds=3600;

    private int refreshTokenValiditySeconds=10000;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailService();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(this.authenticationManager)
                .tokenServices(tokenServices())
                .tokenStore(tokenStore())
                .accessTokenConverter(accessTokenConverter());
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("twitter-app")
                .authorizedGrantTypes("client_credentials", "password", "refresh_token")
                .authorities("ROLE_TRUSTED_CLIENT")
                .scopes("read", "write")
                .resourceIds(resourceId)
                .accessTokenValiditySeconds(accessTokenValiditySeconds)
                .refreshTokenValiditySeconds(refreshTokenValiditySeconds)
                .secret("secret");
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

//    @Autowired
//    private SecretKeyProvider keyProvider;

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        try {
//            converter.setSigningKey(keyProvider.getKey());
//        } catch (URISyntaxException | KeyStoreException | NoSuchAlgorithmException | IOException | UnrecoverableKeyException | CertificateException e) {
//            e.printStackTrace();
//        }

        return converter;
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        defaultTokenServices.setSupportRefreshToken(true);
        defaultTokenServices.setTokenEnhancer(accessTokenConverter());
        return defaultTokenServices;
    }

}
