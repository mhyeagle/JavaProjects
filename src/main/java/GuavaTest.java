import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


public class GuavaTest {
    public static void main(String[] args) {
        Integer loadCount = 0;

        LoadingCache<String, Optional<String>> testCache = CacheBuilder.newBuilder()
                .expireAfterAccess(5L, TimeUnit.SECONDS)
                .build(
                        new CacheLoader<String, Optional<String>>() {
                            @Override
                            public Optional<String> load(String s) throws Exception {
                                if (s.equals("noExist")) {
                                    System.out.println("key: noExist loading...");
                                }
                                return Optional.empty();
                            }
                        }
                );

        for (int i = 0; i < 3; i++) {
            try {
                testCache.get("noExist").orElse(null);
                Thread.sleep(3L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
