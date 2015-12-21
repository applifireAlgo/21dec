package salesdemo.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import salesdemo.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import salesdemo.app.server.repository.AddressRepository;
import salesdemo.app.shared.location.Address;
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
import salesdemo.app.shared.location.AddressType;
import salesdemo.app.server.repository.AddressTypeRepository;
import salesdemo.app.shared.location.City;
import salesdemo.app.server.repository.CityRepository;
import salesdemo.app.shared.location.Country;
import salesdemo.app.server.repository.CountryRepository;
import salesdemo.app.shared.location.State;
import salesdemo.app.server.repository.StateRepository;

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
            addresstype.setAddressType("MylkFFjMILmLgjAdk0ov3jIoE5rIU7sAAGgaaykU8aenRm6qYs");
            addresstype.setAddressTypeDesc("3C4qQoFjzxNNvahHese8gwwuZoOYoQwPjaaCsTNvOMPYuaPFMy");
            addresstype.setAddressTypeIcon("S9M5MCQQ6GOTpbBJnznhpsNCo6hbxr1Ooc3zQjprB2lAD41AKq");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("7OmoeuyZ4Xro72x9PgOZ9Nt3Y15Idk3O");
            city.setCityDescription("suUIe6eTlmmBp2MuDJEne5HrVRfsK81kpLonOFu5zx0h5IIq5G");
            city.setCityFlag("djcE258ue4vteWuKuNyADLvCVTm8YTlBDzAMmOMam70RDN3eJd");
            city.setCityLatitude(5);
            city.setCityLongitude(10);
            city.setCityName("uZsbpf15HGkCYtbnHyzWvcJickGhz95ovThVpGCuCg2MSysZOK");
            Country country = new Country();
            country.setCapital("f5Kxq8a5ZYh9FJz1OtFrtWdnab72KIBf");
            country.setCapitalLatitude(5);
            country.setCapitalLongitude(8);
            country.setCountryCode1("kZZ");
            country.setCountryCode2("X62");
            country.setCountryFlag("htAXJa32apwnKezan1vbn1CxJN17ZhOaw6j8mkdZEGsd8IATXR");
            country.setCountryName("Q6A6kQDXx1nqmF2i2mXn1cX9RqYZmwBNHblNrBgQnOhCAG3jGT");
            country.setCurrencyCode("91D");
            country.setCurrencyName("4cYdkcB648C2BwAGUkH11RNiMcYWq70LVzmMELEK2wWRPGyrfE");
            country.setCurrencySymbol("d06kxNKGnaQAi03xl9ftWeyIfuNXr6yy");
            country.setIsoNumeric(9);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("H1MVIpPXYd5vyExvrDJbNIdS6YOgKrUB6ayTMkQMEbcTIfRvhM");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(10);
            state.setStateCode(0);
            state.setStateCodeChar2("vfy0kP96xhm9bcX3oxYPG9OjeHejLHmI");
            state.setStateCodeChar3("kWr8xFzASzGXTV6NdBygkAaekekeyLQH");
            state.setStateDescription("wyoJMfUYru1BrQTRIoWJig62c2OUiKmXwnLtymomVp3lEFYFJW");
            state.setStateFlag("3coNUFXQDA7VbOtGAeCIUagFjxGWEt787XTQJwEkVUY9MFVUKP");
            state.setStateName("xdE6GdTsII1Sh29sHvSSdfI21vEx1mZCAjZXBw7pTCGDKPJ6rw");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("QdzeljYJQkznVzSlFhUg8dbRPsAiS87B");
            city.setCityDescription("J2ZIiT4SI43yRVtL4i7iHPBAzXrSaSyEit2cqjO9lVpZpdTePc");
            city.setCityFlag("khvjBdOb1EHMiIyLUct6Lo6GucZKivJutdoNxV5euwdFi19sBx");
            city.setCityLatitude(10);
            city.setCityLongitude(5);
            city.setCityName("1zsogZ4vFAdJt9sxGsmKGFuk6jRXcms62D3yUcafnWXFysECbx");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("Ezv8baty4EOdq8RL1AhWLBPq5G88EBmXOgs1DbRkf42rgDKIlF");
            address.setAddress2("V85Pd8D6F6t8PmzS0vI8GYDG1FfQu9xMtCP430kbIt9TKMcEvJ");
            address.setAddress3("X54y6g0AsCZ293Y9vRzVuF9rprjG0Qo1aR9EOgIEKN1ENU5hrB");
            address.setAddressLabel("InZwTcT9WcK");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("fBxxs94LI44h7jEgvQ5FfOe6iP6R6Nz5q63HHpoEZ2xukr0yXt");
            address.setLongitude("kpeU7t2qkJNxLWMVzx6cVLJbRGKTEj4GOWkvCq3QjTEwJPDhak");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("nQrMF3");
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
            address.setAddress1("WHZt8PiVHIMzHNy4nQ8Nb5ENdigNfWwkwXQ1pUC6vKvJzt31Tt");
            address.setAddress2("whoQwDiElf1zwPebRyPlL3SKa1sOjGmVcWl3l4kxM7zkXhtloN");
            address.setAddress3("jTApiuiwADVHklCh0omKWwLHzBoYUEeGNC2mpr3MiIpMSkh4lp");
            address.setAddressLabel("c3Mi9lUHZuU");
            address.setLatitude("QkbFR9bt7cVUWmWZvcxQzAw9YUDCQZ93UMDYwqfcVjmEzIgjZd");
            address.setLongitude("Z98FSWn0m9qLftwtWawT4xOqk65W61jdP9VGgB7NvifdajdPuB");
            address.setVersionId(1);
            address.setZipcode("t6NW9Z");
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
