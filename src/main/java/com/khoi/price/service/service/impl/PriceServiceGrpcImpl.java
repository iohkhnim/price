package com.khoi.price.service.service.impl;

import com.khoi.price.dao.IPriceDAO;
import com.khoi.price.dto.Price;
import com.khoi.proto.CreateRequest;
import com.khoi.proto.CreateResponse;
import com.khoi.proto.DeleteRequest;
import com.khoi.proto.DeleteResponse;
import com.khoi.proto.GetPriceHistoryRequest;
import com.khoi.proto.GetPriceRequest;
import com.khoi.proto.GetPriceResponse;
import com.khoi.proto.PriceEntry;
import com.khoi.proto.PriceServiceGrpc;
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

  @Override
  public void getPrice(GetPriceRequest request, StreamObserver<GetPriceResponse> streamObserver) {
    streamObserver.onNext(
        GetPriceResponse.newBuilder().setPrice(priceDAO.findPrice2(request.getProductId()))
            .build());
    streamObserver.onCompleted();
  }

  @Override
  public void create(CreateRequest request, StreamObserver<CreateResponse> streamObserver) {
    Price price = Price.fromProto(request);
    priceDAO.create(price);
    streamObserver.onNext(CreateResponse.newBuilder().setId(price.getId()).build());
    streamObserver.onCompleted();
  }

  @Override
  public void delete(DeleteRequest request, StreamObserver<DeleteResponse> streamObserver) {
    priceDAO.deleteByProductId(request.getProductId());
    streamObserver.onNext(DeleteResponse.getDefaultInstance());
    streamObserver.onCompleted();
  }

}
