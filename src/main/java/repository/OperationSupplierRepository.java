package repository;

import java.util.List;

public interface OperationSupplierRepository {

    List<String> whenWasSend(String providerName, String name, String city, String street);

}
