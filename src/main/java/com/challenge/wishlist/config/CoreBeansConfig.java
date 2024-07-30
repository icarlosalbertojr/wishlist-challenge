package com.challenge.wishlist.config;

import com.challenge.wishlist.core.repository.WishlistRepository;
import com.challenge.wishlist.core.usecase.addproduct.AddProductWishlistUseCase;
import com.challenge.wishlist.core.usecase.addproduct.AddProductWishlistUseCaseImpl;
import com.challenge.wishlist.core.usecase.create.CreateWishlistUseCase;
import com.challenge.wishlist.core.usecase.create.CreateWishlistUseCaseImpl;
import com.challenge.wishlist.core.usecase.getallproducts.GetAllProductsWishlistUseCase;
import com.challenge.wishlist.core.usecase.getallproducts.GetAllProductsWishlistUseCaseImpl;
import com.challenge.wishlist.core.usecase.getproduct.GetProductWishlistUseCase;
import com.challenge.wishlist.core.usecase.getproduct.GetProductWishlistUseCaseImpl;
import com.challenge.wishlist.core.usecase.removeproduct.RemoveWishlistProductUseCase;
import com.challenge.wishlist.core.usecase.removeproduct.RemoveWishlistProductUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreBeansConfig {

    private final Integer maxLimit;

    @Autowired
    public CoreBeansConfig(@Value("${service.params.wishlist.maxLimit}") Integer maxLimit) {
        this.maxLimit = maxLimit;
    }

    @Bean
    public AddProductWishlistUseCase addProductWishlistUseCase(final WishlistRepository repository) {
        return new AddProductWishlistUseCaseImpl(repository);
    }

    @Bean
    public RemoveWishlistProductUseCase removeWishlistProductUseCase(final WishlistRepository repository) {
        return new RemoveWishlistProductUseCaseImpl(repository);
    }

    @Bean
    public CreateWishlistUseCase createWishlistUseCase(final WishlistRepository repository) {
        return new CreateWishlistUseCaseImpl(maxLimit, repository);
    }

    @Bean
    public GetAllProductsWishlistUseCase getAllProductsWishlistUseCase(final WishlistRepository repository) {
        return new GetAllProductsWishlistUseCaseImpl(repository);
    }

    @Bean
    public GetProductWishlistUseCase getProductWishlistUseCase(final WishlistRepository repository) {
        return new GetProductWishlistUseCaseImpl(repository);
    }

}