package com.khoi.price.service.service.impl;


import com.khoi.price.dao.IPriceDAO;
import com.khoi.proto.*;
import com.khoi.proto.PriceServiceGrpc;
import com.khoi.proto.GetPriceHistoryRequest;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GRpcService
public class PriceServiceGrpcImpl extends PriceServiceGrpc.PriceServiceImplBase {

  @Autowired
  private IPriceDAO priceDAO;

  @Override
  public void getPriceHistory(GetPriceHistoryRequest request,
      StreamObserver<PriceEntry> streamObserver) {
    priceDAO.findProductPriceHistory(request.getProductId()).forEach(e -> {
      streamObserver.onNext(e.toProto());
    });
    streamObserver.onCompleted();
  }

}
