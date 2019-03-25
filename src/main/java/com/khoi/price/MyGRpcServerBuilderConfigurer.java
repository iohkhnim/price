package com.khoi.price;

import io.grpc.ServerBuilder;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyServerBuilder;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.SslProvider;
import java.io.File;
import org.lognet.springboot.grpc.GRpcServerBuilderConfigurer;
import org.springframework.stereotype.Component;

@Component
public class MyGRpcServerBuilderConfigurer extends GRpcServerBuilderConfigurer {

  private final String certChainFilePath = "D:\\price\\src\\main\\java\\com\\khoi\\price\\key\\server.crt";
  private final String privateKeyFilePath = "D:\\price\\src\\main\\java\\com\\khoi\\price\\key\\server.pem";

  private SslContextBuilder getSslContextBuilder() throws Exception{
    SslContextBuilder sslContextBuilder = SslContextBuilder
        .forServer(new File(certChainFilePath), new File(privateKeyFilePath));
    return GrpcSslContexts.configure(sslContextBuilder, SslProvider.OPENSSL);
  }

  @Override
  public void configure(ServerBuilder<?> serverBuilder) {
    try {
      ((NettyServerBuilder) serverBuilder).sslContext(getSslContextBuilder().build()).build();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
