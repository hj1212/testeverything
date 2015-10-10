import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.FilterBuilders;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * 作者: LDL
 * 功能说明:
 * 创建日期: 2015/8/21 13:51
 */
public class EsTest {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        final Client client = new TransportClient()
                //.addTransportAddress(new InetSocketTransportAddress("111.204.239.215", 9300));
                .addTransportAddress(new InetSocketTransportAddress("192.168.1.211", 9300));

        /*IndexResponse response = client.prepareIndex("cms_data_internetdb", "info","AU9O4WjTCdZR5WHm8raz")
                .setSource(jsonBuilder()
                                .startObject()
                                .field("myweb", "http://www.baidu.com")
                                .field("nickname", "test")
                                .field("indextime", new Date().getTime())
                                .endObject()
                )
                .execute()
                .actionGet();*/
        // isCreated() is true if the document is a new one, false if it has been updated
        //System.out.println("isCreated: " + response.isCreated());


        /*GetResponse response = client.prepareGet("cms_data_internetdb", "info","AU9O4WjTCdZR5WHm8raz")
                .execute()
                .actionGet();*/
        /*UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index("cms_data_internetdb");
        updateRequest.type("info");
        updateRequest.id("53ee6d9d0990c234");
        updateRequest.doc(jsonBuilder()
                .startObject()
                .field("nickname", "hahahahaha")
                .field("myweb", "hahahahaha")
                .field("nickname", "hahahahaha")
                .endObject());
        client.update(updateRequest).get();*/


        /*IndexRequest indexRequest = new IndexRequest("cms_data_internetdb", "info","AU9O4WjTCdZR5WHm8raz")
                .source(jsonBuilder()
                        .startObject()
                        .field("myweb", "http://www.baidu.com")
                        .field("nickname", "test")
                        .field("indextime", new Date().getTime())
                        .endObject());
        UpdateRequest updateRequest = new UpdateRequest("cms_data_internetdb", "info","AU9O4WjTCdZR5WHm8raz")
                .doc(jsonBuilder()
                        .startObject()
                        .field("myweb", "http://www.sina.com")
                        .endObject())
                .upsert(indexRequest);
        client.update(updateRequest).get();*/


        /*DeleteResponse response = client.prepareDelete("cms_data_internetdb", "info","53ee6d9d0990c234")
                .execute()
                .actionGet();
        // Index name
        System.out.println("index: " + response.getIndex());
        // Type name
        System.out.println("type: " + response.getType());
        // Document ID (generated or not)
        System.out.println("id: " + response.getId());
        // Version (if it's the first time you index this document, you will get: 1)
        System.out.println("version: " + response.getVersion());*/



        /*BulkRequestBuilder bulkRequest = client.prepareBulk();

    // either use client#prepare, or use Requests# to directly build index/delete requests
        bulkRequest.add(client.prepareIndex("cms_data_internetdb", "info")
                        .setSource(jsonBuilder()
                                        .startObject()
                                        .field("myweb", "http://www.sohou.com")
                                        .field("nickname", "test")
                                        .field("indextime", new Date().getTime())
                                        .endObject()
                        )
        );

        bulkRequest.add(client.prepareIndex("cms_data_internetdb", "info")
                        .setSource(jsonBuilder()
                                        .startObject()
                                        .field("myweb", "http://www.sina.com")
                                        .field("nickname", "test1")
                                        .field("indextime", new Date().getTime())
                                        .endObject()
                        )
        );

        BulkResponse bulkResponse = bulkRequest.execute().actionGet();
        System.out.println(bulkResponse.hasFailures());*/



        /*BulkProcessor bulkProcessor = BulkProcessor.builder(
                client,
                new BulkProcessor.Listener() {
                    @Override
                    public void beforeBulk(long executionId,
                                           BulkRequest request) {
                        System.out.println("before bulk");
                    }

                    @Override
                    public void afterBulk(long executionId,
                                          BulkRequest request,
                                          BulkResponse response) {
                        System.out.println("after bulk: "+response.hasFailures());
                    }

                    @Override
                    public void afterBulk(long executionId,
                                          BulkRequest request,
                                          Throwable failure) {
                        System.out.println("after bulk error : "+failure.getLocalizedMessage());
                    }
                })
                .setBulkActions(5000)
                .setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB))
                .setFlushInterval(TimeValue.timeValueSeconds(5))
                .setConcurrentRequests(1)
                .build();
        final Map<String,Object> source = new HashMap<>();
        source.put("myweb", "http://www.sina.com");
        source.put("nickname", "test1");
        source.put("indextime", new Date().getTime());
        bulkProcessor.add(new IndexRequest("cms_data_internetdb", "info").source(source));
        bulkProcessor.add(new DeleteRequest("cms_data_internetdb", "info", "AU9O9hqNCdZR5WHm8ra0"));
        bulkProcessor.close();*/

        /*SearchRequestBuilder searchRequestBuilder = client.prepareSearch("user_center1")
                .setTypes("user_center1")
                .setSearchType(SearchType.COUNT)
                .addAggregation(avg("domain_count")
                        .field("domain"));
        System.out.println(searchRequestBuilder);
        SearchResponse response = searchRequestBuilder
                .execute()
                .actionGet();
        System.out.println(response);
        SearchHits searchHits = response.getHits();*/


        /*QueryBuilder qb = termQuery("content", "夫妻");

        SearchResponse scrollResp = client.prepareSearch("cms_data_internetdb")
                .setSearchType(SearchType.SCAN)
                .setScroll(new TimeValue(60000))
                .setQuery(qb)
                .setSize(100).execute().actionGet();//100 hits per shard will be returned for each scroll
        //Scroll until no hits are returned
        while (true) {

            for (SearchHit hit : scrollResp.getHits().getHits()) {
                System.out.println(hit.getId());
            }
            System.out.println(scrollResp.getScrollId());
            scrollResp = client.prepareSearchScroll(scrollResp.getScrollId()).setScroll(new TimeValue(600000)).execute().actionGet();
            //Break condition: No hits are returned
            if (scrollResp.getHits().getHits().length == 0) {
                break;
            }
        }*/

        /*SearchRequestBuilder srb1 = client
                .prepareSearch().setQuery(QueryBuilders.queryStringQuery("夫妻")).setSize(1);
        SearchRequestBuilder srb2 = client
                .prepareSearch().setQuery(QueryBuilders.matchQuery("nickname", "test1")).setSize(1);

        MultiSearchResponse sr = client.prepareMultiSearch()
                .add(srb1)
                .add(srb2)
                .execute().actionGet();

        // You will get all individual responses from MultiSearchResponse#getResponses()
        long nbHits = 0;
        for (MultiSearchResponse.Item item : sr.getResponses()) {
            SearchResponse response = item.getResponse();
            nbHits += response.getHits().getTotalHits();
            for (SearchHit hit : response.getHits().getHits()) {
                System.out.println(hit.getId());
            }
        }
        System.out.println(nbHits);*/

        /*SearchResponse sr = client.prepareSearch()
                .setQuery(QueryBuilders.matchAllQuery())
                .addAggregation(
                        AggregationBuilders.terms("agg1").field("field")
                )
                .addAggregation(
                        AggregationBuilders.dateHistogram("agg2")
                                .field("birth")
                                .interval(DateHistogram.Interval.YEAR)
                )
                .execute().actionGet();

        // Get your facet results
        Terms agg1 = sr.getAggregations().get("agg1");
        DateHistogram agg2 = sr.getAggregations().get("agg2");*/

        /*CountResponse response = client.prepareCount("cms_data_internetdb")
                .setQuery(termQuery("nickname", "test"))
                .execute()
                .actionGet();
        System.out.println(response.getCount());*/

        /*SearchResponse sr = client.prepareSearch("cms_data_internetdb");
        TermsFacet f = (TermsFacet) sr.getFacets().facetsAsMap().get("nickname");

        f.getTotalCount();      // Total terms doc count
        f.getOtherCount();      // Not shown terms doc count
        f.getMissingCount();    // Without term doc count

        // For each entry
        for (TermsFacet.Entry entry : f) {
            entry.getTerm();    // Term
            entry.getCount();   // Doc count
        }*/

        //select nickname,userid from cms_data_internetdb group by nickname order by nickname
        SearchResponse response = client.prepareSearch("cms_data_saibo").setTypes("info")
                .setSearchType(SearchType.DEFAULT)
                //.setQuery(termQuery("title", "传媒专业"))

                        .setPostFilter(FilterBuilders.termFilter("title", "传媒专业"))
                                //.setQuery(QueryBuilders.rangeQuery("nickname"))
                .execute().actionGet();
        System.out.println(response);

        /*for (Terms.Bucket b : agg.getBuckets()) {
            System.out.println("filedname:" + b.getKey() + "     docCount:" + b.getDocCount());
            Terms classTerms = b.getAggregations().get("terms");
            for (Terms.Bucket b2 : classTerms.getBuckets()) {
                System.out.println(b2.getKey() + ",,,,," + b2.getDocCount());
            }
        }*/
    }
}