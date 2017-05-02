import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/2.
 */
public class MongoDBJDBC {
    public static void main(String args[]) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("runoob");
        System.out.println("Connect to database successfully");
//        mongoDatabase.createCollection("test");
//        System.out.println("Create collection successfully");
        MongoCollection<Document> collection = mongoDatabase.getCollection("col");
        System.out.println("choose col collection successfully");
//        Document document = new Document("title", "MongoDB")
//                .append("description","database")
//                .append("likes", 100)
//                .append("by","Fly");
//        List<Document> documents = new ArrayList<Document>();
//        documents.add(document);
//        collection.insertMany(documents);
//        System.out.println("insert document successfully");
//        collection.updateMany(Filters.eq("likes", 100), new Document("$set", new Document("likes", 200)));
        collection.deleteOne(Filters.eq("likes", 200));
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()) {
            System.out.println(mongoCursor.next());
        }
    }
}
