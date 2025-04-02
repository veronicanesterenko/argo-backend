package com.website.argo.service.implementation;

import com.website.argo.service.ProductService;
import com.website.argo.entity.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Service
@Transactional(readOnly = true)
@Primary
public class DummyProductServiceImpl implements ProductService {
    @Override
    public List<Product> findAll() {
        try {
            return List.of(Product.builder().name("Коллагеновый напиток")
                    .supplementsFacts("Гидролизованный коллаген, витамин С, витамин Е, витамины группы B, цинк, медь, гиалуроновая кислота, экстракт ягод асаи, натуральный ароматизатор, подсластитель стевия.")
                    .mainImage(Files.readAllBytes(new File("collagen_drink.e2c869cc36d4e5084ab9.webp").toPath()))
                    .shortDescription("Коллагеновый напиток представляет собой инновационную формулу, разработанную для поддержания здоровья суставов, кожи, волос и ногтей.")
                    .fullDescription("Коллагеновый напиток представляет собой инновационную формулу, разработанную для поддержания здоровья суставов, кожи, волос и ногтей. В состав входит гидролизованный коллаген высокого качества, который легко усваивается организмом. Напиток обогащен витаминами C, E, группы B, а также микроэлементами, необходимыми для синтеза собственного коллагена. Регулярное применение помогает замедлить процессы старения, увеличить эластичность кожи, уменьшить боли в суставах и улучшить общее состояние соединительных тканей.")
                    .score(3L)
                    .build()
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
