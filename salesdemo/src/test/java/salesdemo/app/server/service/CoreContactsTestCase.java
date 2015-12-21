package salesdemo.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import salesdemo.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import salesdemo.app.server.repository.CoreContactsRepository;
import salesdemo.app.shared.contacts.CoreContacts;
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
import salesdemo.app.shared.contacts.Gender;
import salesdemo.app.server.repository.GenderRepository;
import salesdemo.app.shared.location.Language;
import salesdemo.app.server.repository.LanguageRepository;
import salesdemo.app.shared.location.Timezone;
import salesdemo.app.server.repository.TimezoneRepository;
import salesdemo.app.shared.contacts.Title;
import salesdemo.app.server.repository.TitleRepository;
import salesdemo.app.shared.contacts.CommunicationData;
import salesdemo.app.shared.contacts.CommunicationGroup;
import salesdemo.app.server.repository.CommunicationGroupRepository;
import salesdemo.app.shared.contacts.CommunicationType;
import salesdemo.app.server.repository.CommunicationTypeRepository;
import salesdemo.app.shared.location.Address;
import salesdemo.app.server.repository.AddressRepository;
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
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            Gender gender = new Gender();
            gender.setGender("uqQZShfuLCiKPopChduHSxZKFoW0aU34AgcIZSLbgw48mER98G");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("T0");
            language.setAlpha3("GXF");
            language.setAlpha4("9Gps");
            language.setAlpha4parentid(7);
            language.setLanguage("xLaMSdH3CzhmaEbcOsAe7PoIMON9Xg4taBdiURzjwMkqcRSkK3");
            language.setLanguageDescription("KR01QDEXcEsaiQEHmJLzwPTqnVR68kiXBVoft6NdNG6UEbuDbf");
            language.setLanguageIcon("uxsynSi1hGaPTLX8WxFThZYVHtRfXetsW6bVUzYAYxvtrRJbOf");
            language.setLanguageType("7hLxsTpnZDGyUIfJkH1Us9RUYXYRfAkk");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("gr14BHVh1cPqnw1FDui41boNQJ9Yuwb7qaXtCrzidkyBRZh4H8");
            timezone.setCountry("stnvJ37D5lfkJ4ZMoYX3H6pOuD5IRpL3jEQXdFMK9k2vCddI84");
            timezone.setGmtLabel("e9ykMMqneZu7sWgvoklOoBSVIOZuAH3kXstSGzCFoM9HHGHlyq");
            timezone.setTimeZoneLabel("svA9I7zUR3PyBEuKsG6cZfDlrB88EsMWqo4Nuc7ZES6Yi2S66T");
            timezone.setUtcdifference(2);
            Title title = new Title();
            title.setTitles("PYONrMXs0LJQ4K9PHpnaIOW4zRUlSyWGBCUxz0my0qjq89C5Mw");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(40);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("pG3omEDkjXZlOxwlAogcncQrhE3whxOhoNjpxji1Zz4XcdWVRQ");
            corecontacts.setFirstName("bMoTjQ8MSqJ1Sglg4CiAoGHhGNxvtWUwZLUAI4rVmgHzr1TyoF");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("uL7nBDNFhLKJFdXGLxQHOhlWIIHEFOAM58DsWwuMTWop4Lr2JC");
            corecontacts.setMiddleName("vVib5ZNYEh9ZtgsHHGCePS3pdycwMnrzV6oh9R6HctlkGXs45x");
            corecontacts.setNativeFirstName("lOln07tUzzhM6LqgskBFcSxf02JPkMxky2HOM1EuiZMKrw4Bl3");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("EJokCD19JlBQAVfwdoNYyz634Gy8Te5L2DafMOXk4FZRXLx1NA");
            corecontacts.setNativeMiddleName("LTOmzETIktwY9gLKy3uiNAfnjQpI9ENsMTMuLRqHXbcVwpxVXg");
            corecontacts.setNativeTitle("xBQGjfrcn64nHf6na7IOIws8IElZdULCUiqXsHycTRAIqoQhvA");
            corecontacts.setPhoneNumber("etawRNd8MJez72tdz9NY");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("67z");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("NSTPKbdWD32F39G94eafhxT7Rqdk8JKgZSaoA9dt0oEFlYgQpK");
            communicationgroup.setCommGroupName("jZRc5NRQ1YdWts52FLicpJCwdfalvOSbd8kolEh0aLHbnRCeI7");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("GKFXSwvdehZMqsltBDhQnd6sQsl695MmJxl6PqWx9A1Otqw6gZ");
            communicationtype.setCommTypeName("a7oIJHMzkhIHtK3rFmR2eNlcuK2NCb36VbnWVOCcDbSFQKOgOp");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("6zr");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("rvyY5L1b6AURHuHQl2pWSjpL6cSE9aM3sZ8GpWZy9fG12f5Uof");
            address.setAddress2("ZxQrKVJH1tafEis8TntQtMc3WV0JEzfO1itvdZ0NHT0hC6iako");
            address.setAddress3("UEiHv6dhIqrVdkhVjsh8th7Kxfo2xsEmwRaXdNNc4JYGk8lY87");
            address.setAddressLabel("K5WMlPPtixS");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("rArnk6lrLNpxsk414Fys39R5euYkYvfvkkNZQ5elWdNjX3jOGZ");
            addresstype.setAddressTypeDesc("PjBdgr8ZwPW7VSWEVbau4tjzSr3Aj6mIBgjpNIrCX60gMwUtpH");
            addresstype.setAddressTypeIcon("dAP5Mm7VGwwiwnDiAk1wcrodBN8a5vXP9xSDL61hyx9rMnklnS");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("WQmkTMuwqeeSw0B5YwZ9HzNDBuEfoXAs");
            city.setCityDescription("ezdqbxSwu9zyQmspMXgW5ZUPyiVC5eTFZY8zEWyQgbh0j0h4Uz");
            city.setCityFlag("8iNVSq7ex9PA7HLm1pA8aIkVaHZmpeRiLFfu7mdZwJ6Jgo70RN");
            city.setCityLatitude(7);
            city.setCityLongitude(1);
            city.setCityName("yklYh3Q5pAOQynH5pHVDNQEAdLsPijKMKawHeUf4vMXSH51nkO");
            Country country = new Country();
            country.setCapital("hYOEpPCBK0WwUoT7tY84GA7Mif1tUeo8");
            country.setCapitalLatitude(2);
            country.setCapitalLongitude(7);
            country.setCountryCode1("yOw");
            country.setCountryCode2("yYr");
            country.setCountryFlag("oxsSjvyx6uv8efsF9RbQxmlKShEeULG9N9SpA5EkksyssLuXdf");
            country.setCountryName("Q5A9AtPzpq2MdVlB4hJVNGzN4g40UVE5m3ZoYFDa3R3xMiE1YQ");
            country.setCurrencyCode("3f9");
            country.setCurrencyName("qvGF0OJMzIejAhC8DYjEnn8N57RoerHBrNaCecRdbqXZTp0Ata");
            country.setCurrencySymbol("hfgdyCN0aerscSKlDPEjgY01WXUZCWqq");
            country.setIsoNumeric(0);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("eN20OcmtFr7JX8CyjAO7TPvLkxkqBiS0h5jrDGpySKwXiiM32q");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(0);
            state.setStateCode(2);
            state.setStateCodeChar2("2VV19qcapjMfkqWfDLdvnDVwCbna5llJ");
            state.setStateCodeChar3("oOmdDHvGjDpho9xkC24NZWWvGXnlgzrV");
            state.setStateDescription("qPJIraEtQXaeNCXBQfV9DucnKu9GK5E8uFQdTjUYFgqtFfiIT1");
            state.setStateFlag("8s2FIQb3ODoueTa0bIGEqs6ImpkHxDIaeKAXWPv24A0uIIwrOM");
            state.setStateName("5zX4ccCnlAos2NUAoV11JoZrvzD96bJ1VsOV9DBrXgd7tK4XxI");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("SdHQX7BwiHjAlEifJIAfBNnjVvjNztCS");
            city.setCityDescription("HaRC9OtOoA2aJ38wDzxLL92Bj8dgpsjTHY9J5RRgvbeJcqMjWI");
            city.setCityFlag("mY7Gg7e3DT5YMcekScP3b3hEGiU1NNYCWq9W7lePw8j7VlEu4T");
            city.setCityLatitude(5);
            city.setCityLongitude(7);
            city.setCityName("D1DhXGDvSzsgBKFW9Fo9kwjb7EtNK9VDcN0lc2bN3FVIBqElL4");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("WeFZb6PlErQu0Q5IXAjNeH8EiNaNY75msIxQo5FA90dKWkogOi");
            address.setAddress2("kE5KQwcVIacf4lFJ2gSiWNtECNP0SmhhED6r9BAnkxsLcLKFXS");
            address.setAddress3("ca3Sr9i0OrOG17CD3FesRTeNoklFCETytV22Ww9u99kYIkVy1f");
            address.setAddressLabel("MzznuzPpDiM");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("RXpFGubHpXZUGg8T7IWPAwHmPZYutAoGYPGU8ZXbeKFTkcHX3c");
            address.setLongitude("zY5hoK1PJZRLcSDTNz7ypB0LDAQ53wChiBCoKXz9R5LQBqmDqA");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("nT6gu2");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            map.put("TimezonePrimaryKey", corecontacts.getTimezone()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(62);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("USmeTq4jNug4faJ7GvqGn5g0dKsY7XzNyt0SLqUHWy4o0Jm3dH");
            corecontacts.setFirstName("s73P5OGPs0x7dquY4O53qvpwI5AsmLwOXZjnLZbBbNxT0ZNueG");
            corecontacts.setLastName("w9z4GmvR2q8UdYkglKPQA16pU3LX9xolcTM479f5m7e6E7WOUs");
            corecontacts.setMiddleName("O1B8277iN9kO9mF7BnuC4xB7W5nPdDOt24JWmMjkghmEgBRusA");
            corecontacts.setNativeFirstName("CCkujypU0Vavefz6rJncDbI5ZEPt0WzDCAZ1rwPSlD9d9OC3lm");
            corecontacts.setNativeLastName("y6qxBntpgpZUpAM5V4pp9qySF0w9RZ2hwfVvGjG5pny7q9nwLl");
            corecontacts.setNativeMiddleName("0ga8LDvhXIST8cNgHpyWzrqCXjpiXnAaTNodJrVxQtGNQKc25F");
            corecontacts.setNativeTitle("Lk5wd57IhCnJV5HYr4YkGWSkYr47qhnVxKuvfiqpBcxLWovN7v");
            corecontacts.setPhoneNumber("3TCac4sHhKxZ4P9ERRkI");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
