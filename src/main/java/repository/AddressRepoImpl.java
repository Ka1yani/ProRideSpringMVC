package repository;

import jakarta.persistence.EntityManager;
import model.Address;
import repository.interfaces.AddressRepo;
import utility.PersistenceUtility;

import java.util.List;

public class AddressRepoImpl implements AddressRepo {
    private final EntityManager entityManager = PersistenceUtility.getEntityManager();
    @Override
    public void save(Address address) {
        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();
    }

    @Override
    public Address findById(int id) {
        return entityManager.find(Address.class, id);
    }

    @Override
    public List<Address> findAll() {
        return  entityManager.createQuery("select a from Address a", Address.class).getResultList();
    }

    @Override
    public void update(Address address) {
        entityManager.getTransaction().begin();
        entityManager.merge(address);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Address address) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(address) ? address : entityManager.merge(address));
        entityManager.getTransaction().commit();

    }

    @Override
    public List<Address> findByUserId(int userId) {
        return entityManager.createQuery("SELECT a FROM Address a WHERE a.user.userId = :userId", Address.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public List<Address> findByDriverId(int driverId) {
        return entityManager.createQuery("SELECT a FROM Address a WHERE a.driver.userId = :driverId", Address.class)
                .setParameter("driverId", driverId)
                .getResultList();
    }

    @Override
    public List<Address> findByCity(String city) {
        return entityManager.createQuery("SELECT a FROM Address a WHERE a.city = :city", Address.class)
                .setParameter("city", city)
                .getResultList();
    }

    @Override
    public List<Address> findByLocationType(String locationType) {
        return entityManager.createQuery("SELECT a FROM Address a WHERE a.locationType = :locationType", Address.class)
                .setParameter("locationType", locationType)
                .getResultList();
    }
}
