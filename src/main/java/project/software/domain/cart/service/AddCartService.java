package project.software.domain.cart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.cart.domain.repository.CartRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class AddCartService {

    private final CartRepository cartRepository;

}
