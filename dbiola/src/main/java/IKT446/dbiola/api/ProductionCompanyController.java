package IKT446.dbiola.api;

import IKT446.dbiola.repository.ProductionCompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prod_company")
public class ProductionCompanyController {

    private final ProductionCompanyRepo prodCompanyRepo;

    @Autowired
    public ProductionCompanyController(ProductionCompanyRepo prodCompanyRepo) {
        this.prodCompanyRepo = prodCompanyRepo;
    }

}
