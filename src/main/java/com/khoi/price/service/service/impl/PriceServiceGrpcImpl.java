package com.khoi.price.service.service.impl;


import com.khoi.price.dao.IPriceDAO;
import com.khoi.proto.*;
import com.khoi.proto.PriceServiceGrpc;
import com.khoi.proto.getPriceHistoryRequest;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceGrpcImpl extends PriceServiceGrpc.PriceServiceImplBase {

  @Autowired
  private IPriceDAO priceDAO;

  public void getProductPriceHistory(getPriceHistoryRequest request,
      StreamObserver<PriceEntry> streamObserver) {
    priceDAO.findProductPriceHistory(request.getProductId()).forEach(e -> {
      streamObserver.onNext(e.toProto());
    });
    streamObserver.onCompleted();
  }

}
