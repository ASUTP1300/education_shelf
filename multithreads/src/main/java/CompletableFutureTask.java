import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTask {

    /**
     * Иммитируем ситуацию, клиент ждет ответа Сервера без блокировки потока
     *
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8888/persons/new")).GET().build();

        CompletableFuture<String> completableFuturePrint = CompletableFuture.supplyAsync(() ->
                {
                    try {
                        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                        System.out.println(response.body());
                        return response.body();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

        );


        completableFuturePrint
                .thenApply(r -> (String) r)
                .thenAccept(s -> System.out.println("Result of COMPLETABLE FUTURE\n" + s));

        Thread.sleep(1000);

        CompletableFuture<List<String>> completableFuture1 = CompletableFuture
                .supplyAsync(() -> List.of("A", "B", "C", "D"));

        CompletableFuture<Void> completableFuture2 = completableFuture1.
                thenApply(l -> l.subList(0, 3)).
                thenApply(l -> l.get(0))
                .thenAccept(System.out::println);

    }
}
