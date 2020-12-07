package IKT446.dbiola.api;

import IKT446.dbiola.repository.ProductionCountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prod_country")
public class ProductionCountryController {

    private final ProductionCountryRepo prodCountryRepo;

    @Autowired
    public ProductionCountryController(ProductionCountryRepo prodCountryRepo) {
        this.prodCountryRepo = prodCountryRepo;
    }

}
