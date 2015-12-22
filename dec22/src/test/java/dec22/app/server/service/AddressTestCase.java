package dec22.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import dec22.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import dec22.app.server.repository.AddressRepository;
import dec22.app.shared.location.Address;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import dec22.app.shared.location.AddressType;
import dec22.app.server.repository.AddressTypeRepository;
import dec22.app.shared.location.City;
import dec22.app.server.repository.CityRepository;
import dec22.app.shared.location.Country;
import dec22.app.server.repository.CountryRepository;
import dec22.app.shared.location.State;
import dec22.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("abu8ZlykKTaqNuc88hF5LYrnhhnZiQ3hkvPpQXOodvRZQmSLo2");
            addresstype.setAddressTypeDesc("lBKgo4wiLn8AuLbYlTeDtXTlIWnmxqcYucmX0Tcpwv51ebpLYS");
            addresstype.setAddressTypeIcon("5j8xACyRF6ZMUuUmz7RuStbCoEzJsCYERA3jj7L6ub82uBfF4s");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("CuQ8f4Hb5UbqUdRVOe5yfdQpoJreadMl");
            city.setCityDescription("qxIgKyhqeUqMmB0aBY2kTxC2fS8Zc3pUXGJv2kAa8JKUW5aLou");
            city.setCityFlag("4wmMKtHvvswJvJbWiQUm2XB9K1RHdozIWNNYxqIjdHcO89eiKX");
            city.setCityLatitude(0);
            city.setCityLongitude(5);
            city.setCityName("kyehpYYccBrnMCS2pJreeH9Hz1D36hZsXQaVU9vuVTD3jzXxLb");
            Country country = new Country();
            country.setCapital("PMFystFpriUH2s7Pf69vdpKCcy2WNjqf");
            country.setCapitalLatitude(7);
            country.setCapitalLongitude(1);
            country.setCountryCode1("MoH");
            country.setCountryCode2("Gn7");
            country.setCountryFlag("W47q4eGjczv9XzbJPT6V6dXPDWKIF3SayyfhfMe7WZRnpeXuy3");
            country.setCountryName("uceNdT288KbI2N4RqrwRIerSOz0BHnAOMTJ6GynjmqF5RLBty2");
            country.setCurrencyCode("tUe");
            country.setCurrencyName("8QF0GMeD6xxmbU8DQ36baAG87VQwR2D8XJ55R1VtGHr3IQ9nmJ");
            country.setCurrencySymbol("GeqJIQ2fFJimnA5iWWgPpBFJh8y6fzkZ");
            country.setIsoNumeric(2);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("80hKvnYopERDqdlArlgNilVUhq5pTzuZAmXbZlOU5C8r6U7oEz");
            state.setStateCapitalLatitude(5);
            state.setStateCapitalLongitude(1);
            state.setStateCode(2);
            state.setStateCodeChar2("xQXZLcWZtm6ZpGejiN9cJHZgRqCFCJ4e");
            state.setStateCodeChar3("5Uq7XeH40KSvV1mcEonuisUVOKk75XYb");
            state.setStateDescription("QpXvQYiIYuBEbIzErIxbgwr6QpkFREwKSWWxeBKQ6CHtpyP2Tq");
            state.setStateFlag("SBydQQdF8rYBGyk7jt4i8oWjmGUtuk7VqBRke3tce2ZJ4aaobj");
            state.setStateName("9JK68B94lSHH5xhkJXkYqc7Y4is1yef5rbLJAyyXSAtdR4J2uD");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("6zxC1EkNYCHt9EasDBMqVzARGHcw2iO7");
            city.setCityDescription("9fU9PWEl999hrWvj9pUoO4ic8njdzQER3q7swmFhWX7wvDS5Uf");
            city.setCityFlag("YkkwryMUwJbC0VsaPm5PRkTHwMoUICIWFfXxjx2xVXgrIpGq6c");
            city.setCityLatitude(6);
            city.setCityLongitude(10);
            city.setCityName("amnmkqeeDFV3tnFktErbapK8TQRjWNxfW3wBOQEysafFG9vtuU");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("ilOeXOcgk8pm7Y40BcYZHxfx5VpRM1VOFFn9amajud4ZtCJJyW");
            address.setAddress2("cp1Ch80nWpbE9r7OryxOdlmaGQQgoGv14Hmi2lwn7LIKXgD9ZW");
            address.setAddress3("411IUrDAuYc3ZMjlNlO37Mf6ZbTy3T0rV4RHWBdZHJ2NtZlTrQ");
            address.setAddressLabel("CsuUbD8mDxg");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("SBEhiev5OsoYzh10u6VJixS9hNypJqU5p7gzrYaL4QqCfgk2Vu");
            address.setLongitude("Rx3EM6GnZ2Zi4LAc85ytMpOY7inAzYvcu8vWHdemgDB7kWkpeD");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("vzNKaJ");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("JDrabj7Sq4q0SA5KYse1zgViYTMAVnIuGCYDpE4wl8u85kMzRV");
            address.setAddress2("2X47cVYSait1B5YxuVEzGDeCMHDgNYRidxkmI5e6bzSzuyFMub");
            address.setAddress3("uCka4YPIaTCsXpI7EaJFFTN541vUr8MmSs5KRXpfUh3474Fj9p");
            address.setAddressLabel("Oi7FReflRv3");
            address.setLatitude("VQsvixNeC05xm7jmD2LjwxtO4nStueB3l5ldVL4npWwf9LOTKU");
            address.setLongitude("9BMPZd20y1YZUVvfpzdh5Ji9A3vo6BDnVMPdPnuaS2qjF6yyKD");
            address.setVersionId(1);
            address.setZipcode("WQSGYQ");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
