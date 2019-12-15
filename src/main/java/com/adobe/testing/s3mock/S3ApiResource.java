package com.adobe.testing.s3mock;

import com.adobe.testing.s3mock.dto.ListAllMyBucketsResult;
import com.adobe.testing.s3mock.dto.Owner;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/xxx")
public class S3ApiResource {
  private static final Owner TEST_OWNER = new Owner(123, "s3-mock-file-store");

  @Inject
  FileStore fileStore;

  @GET
  @Produces("application/xml")
  public ListAllMyBucketsResult listBuckets() {
    return new ListAllMyBucketsResult(TEST_OWNER, fileStore.listBuckets());
  }
}
