package com.luizalabs.wishlist.dataprovider.database.repository;

import com.luizalabs.wishlist.core.domain.Wishlist;
import com.luizalabs.wishlist.core.repository.WishlistRepository;
import com.luizalabs.wishlist.dataprovider.database.mapper.WishlistDatabaseMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class WishlistRepositoryImpl implements WishlistRepository {

    private final MongoWishlistRepository mongoWishlistRepository;

    @Override
    public Wishlist save(Wishlist wishlist) {
        final var saved = mongoWishlistRepository.save(WishlistDatabaseMapper.convert(wishlist));
        return WishlistDatabaseMapper.convert(saved);
    }

    @Override
    public Optional<Wishlist> findByIdAndCustomerId(String id, String customerId) {
        return mongoWishlistRepository.findByIdAndCustomerId(id, customerId)
                .map(WishlistDatabaseMapper::convert);
    }

    @Override
    public List<Wishlist> findByCustomerId(String customerId) {
        return mongoWishlistRepository.findByCustomerId(customerId)
                .stream()
                .map(WishlistDatabaseMapper::convert)
                .toList();
    }
}
