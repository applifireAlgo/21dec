package dec22.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import dec22.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import dec22.app.server.repository.CoreContactsRepository;
import dec22.app.shared.contacts.CoreContacts;
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
import dec22.app.shared.contacts.Gender;
import dec22.app.server.repository.GenderRepository;
import dec22.app.shared.location.Language;
import dec22.app.server.repository.LanguageRepository;
import dec22.app.shared.location.Timezone;
import dec22.app.server.repository.TimezoneRepository;
import dec22.app.shared.contacts.Title;
import dec22.app.server.repository.TitleRepository;
import dec22.app.shared.location.Address;
import dec22.app.server.repository.AddressRepository;
import dec22.app.shared.location.AddressType;
import dec22.app.server.repository.AddressTypeRepository;
import dec22.app.shared.location.City;
import dec22.app.server.repository.CityRepository;
import dec22.app.shared.location.Country;
import dec22.app.server.repository.CountryRepository;
import dec22.app.shared.location.State;
import dec22.app.server.repository.StateRepository;
import dec22.app.shared.contacts.CommunicationData;
import dec22.app.shared.contacts.CommunicationGroup;
import dec22.app.server.repository.CommunicationGroupRepository;
import dec22.app.shared.contacts.CommunicationType;
import dec22.app.server.repository.CommunicationTypeRepository;

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
            gender.setGender("Irtys9UQMAdP4QsaIJBDZXS199pJmybYFHdirlMeqGIm5w3zj2");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("DJ");
            language.setAlpha3("83m");
            language.setAlpha4("LEup");
            language.setAlpha4parentid(0);
            language.setLanguage("ZDLM1q5QYibjiIaVse6VTLCBveJkjfSKindtajAJ1Bg1kO59Lb");
            language.setLanguageDescription("L9rqIkVZyethTH9q0kMbwgj25YNG77MohLQkJLGjGyAFZcj7IZ");
            language.setLanguageIcon("s91IOfDybzajzSEfCOZE8VhApW2UE1KFpecIzK55nNK1o4gxYa");
            language.setLanguageType("7yDGp8JWkBcyfhAIGBMcexWiRlRk46Rc");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("2O5lqsTfC7rC9mKYueIxwCWn8UcNxcOZ23rPsfjPi2eqkk2kov");
            timezone.setCountry("A7tYf9ur33I48AwwkxmkVJeULYFke0EdSIr1VfZY8VzcLnbkuF");
            timezone.setGmtLabel("rtoyfvziVpnR6WHmAujgJg2ojDiJfsdwK7vLldosWRp52kmvOF");
            timezone.setTimeZoneLabel("lxe2h4mGswCER0eXm7e6o7zgzbWo4H6m1GKDvoP1v75I5pLhm4");
            timezone.setUtcdifference(2);
            Title title = new Title();
            title.setTitles("0ZN5Nn9EFNVqjSjcBOWpAOuOG8OlMR4udV5b0ZevRmPEpsRlP6");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(120);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("7Z6oa3ZpO5sAJArOLIReLUhwC84JVOD8UfJZ5Bw1CkTJJdORQ6");
            corecontacts.setFirstName("P91OPspqreyEz4rU8NA5LCUFhZeV6gwx8lDcEm6I2GhgrUGIyu");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("r1jUOWRxHI3PC5wOhl0Gb8Rx0yFpAPftGqh7w6brYZUUCcf0j9");
            corecontacts.setMiddleName("NTdp8nTdDGuxHvwlrNChEbWX7cp4fCBSNbpWuHzznwtnQeuq0L");
            corecontacts.setNativeFirstName("jmM26dJHFE0pW2FY9yRlLzMygtxpii3Y2uRj0b8wN4l6tRLTmt");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("HBTMJuYyDAagVrz92ILpZUNBtywpRR0RLmQNJM7dBD3KEUtd69");
            corecontacts.setNativeMiddleName("8Qe6PrMXChGGWKFhwqTq816fPuOdhIVMqh5fIewNHkI4iTYzLw");
            corecontacts.setNativeTitle("8mVcwYVLVkAgSQeQ5htb5Xxhmp2EBPOI0OcNB5DlmCdwhvQmY1");
            corecontacts.setPhoneNumber("zvvGo0tolSXSZ39JPfBr");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("HnBE3IA9Om463eIQjJHMDn1LjXaUk4Zfc4MyRKgCT3kd5FlaOp");
            address.setAddress2("9tX3s7HBcf97BllGXfd6JJ3sbojCGnmvpH2ADq0oEGwVrPv5JV");
            address.setAddress3("qFAe6gHNKUDcT5WMbFYwcZdPE67OAvGiznl7v5HTkfWElHRB7p");
            address.setAddressLabel("E6jyxctppod");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("eLpthv9SoEKKbPw5qktWeaQtyHG8Z0yqVR8VhAFa7dYsOVI9OG");
            addresstype.setAddressTypeDesc("YrnnZbpcJO0u3naf0XDDnYDeDzHJGdAT0BH7RdaMHowmEI6ukY");
            addresstype.setAddressTypeIcon("vDQot2J9WoFohnBcCrpfo4ni2hPLlSop7y44TctzZko48sjzcF");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("BlcIWDJx7weTOZ4AX0kNgJ4zTkyGH52S");
            city.setCityDescription("YVtduv1qwZamxeKEakzWmecSHlJ6c9CbgxPPWwdNaCs2JnNRRl");
            city.setCityFlag("52udNi1h4Nf0EwXahGrR3VvtPJWaPb2cVOlxZLtCOkWviLo9qS");
            city.setCityLatitude(9);
            city.setCityLongitude(2);
            city.setCityName("tUsm8eLOUseQZJbQ2DsRCYG9QZf82Erv1Wf6HB5o3hTjh7gALF");
            Country country = new Country();
            country.setCapital("gGEPH4hBYHisOV5rD15oPgjxGsgLz3TQ");
            country.setCapitalLatitude(0);
            country.setCapitalLongitude(8);
            country.setCountryCode1("rod");
            country.setCountryCode2("mUB");
            country.setCountryFlag("bA8VOiOCQpgLULyEkRs2NFwmbGyjfhlXRaQPzJ0losIT9SG2O1");
            country.setCountryName("ySXCkEBgzcthI2SFUAzYxwsTrPSofRix1RwObf3yTWWppkgK7T");
            country.setCurrencyCode("GBY");
            country.setCurrencyName("9h1Bowsb13CdmpIzticfzaoURwLgH3c7PJMbeDKwj45vZklbwP");
            country.setCurrencySymbol("H546yGTLd8cMiY0nwLlle93pWuBAPQ5b");
            country.setIsoNumeric(2);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("uEZYLjVWNfwQn5nFYpcowI0BEougPTV5gRxMXrNA7CF6QCQ4pC");
            state.setStateCapitalLatitude(11);
            state.setStateCapitalLongitude(7);
            state.setStateCode(1);
            state.setStateCodeChar2("wMttsdUezwbwGOp5yAyPULyql1meEKLN");
            state.setStateCodeChar3("xmED1M0vwmxGySNtVdWvoI65bgbZpZST");
            state.setStateDescription("Yx1nVT8CQfKIs8tLP5bNHa4ngDhuYQfvLjWMZqJqizoEPb0fd0");
            state.setStateFlag("2pKAH9rJChlbhdJ70iry03JWwQJmsSs2tOTfYF9o7yQ0Q9Zo3K");
            state.setStateName("sEXZIGsFLXhC7pGq5UapHAwC9G3agAlh2RfngtIW61uLGoCXJB");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("cMJTR0eLlmoqzHg6a2KikBDs8251NYn6");
            city.setCityDescription("3FTIE7W61LBmsSk9kTYf1zYGRhnHrTr6w96Cn65A4bUAP6ygAP");
            city.setCityFlag("FaRjoG6JpgHYP6pk4vRp4M1kOFTzl0SU7lDcvDdxXU7IClMO7W");
            city.setCityLatitude(7);
            city.setCityLongitude(7);
            city.setCityName("1vV0ZICpNsnAgMTFFIl8CP97ipnI6KQalgbXitNs8Tj3bsfQoh");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("odpOShPO7IjU72hu2vG24Lfhw26owCJ2hJJrleb2flgJhRFVYs");
            address.setAddress2("jx38dMFnS2WSElhRq5XazHnP812XZwYBs9ayWfU0cCi7X4S4mJ");
            address.setAddress3("PPfPYpbZvuKxkPLrGpdZD69j1li1zu0kITM5j9ackood6hGvl0");
            address.setAddressLabel("mQjUYTYcQXP");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("PJNnHNIoNv0sWNam4yuvDH0gU1xNMGrf9PgOgzQyQfUliBWqP9");
            address.setLongitude("zOgyAMzj8uszShaorxZG1Xy5wZrSQGHhmBDx2PkQ3pyrrEnG1j");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("4TIqUv");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("Ocp");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("0S428gaMebDui0Kxq7I1KEW0vGneKYiwDCm3khv37o9hdS9kY0");
            communicationgroup.setCommGroupName("QsLXPIvV7Tan2U0EzrZmR9p4iQU7IOE2ajh5nbFuqkVBmtBoqN");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("smP2TywyhjDuU9OcTSaE2UVdVyIv34XNlP5FEMQD8lfh8yCe30");
            communicationtype.setCommTypeName("4jQgrQ9MYP9S5CUyTDKuQHSUlmvsKtRI77Zq5LfVtkerPi4nJa");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("v2G");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
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
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(10);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("WBLXqwJvWTkdE4FnE5a5lRsrYGcJQ2xhJbrRKumJZGx618ET4a");
            corecontacts.setFirstName("ocik3Ft4CogbGpD8XoU91XPqn7YjgDtJcdfgPbKlI1ssQZyLI6");
            corecontacts.setLastName("cEkOKKcsTP9g0JsJ0YqNqSSk3W4qXfzNPn2xT9nDZu9kmLRxFV");
            corecontacts.setMiddleName("LC8szTjk0C3wzv8YJe1xA0jGzqV1EUpIUrktgeY8Eae11hHVNC");
            corecontacts.setNativeFirstName("CMkHP0195Kw2Ua6A0iujVaqaSemVU17uVPdLlSA7FtpmINX0ka");
            corecontacts.setNativeLastName("8ULux22YpkM57nutMeGKg5iAs4inFRzB8OOmZ09odIHGgk3bpU");
            corecontacts.setNativeMiddleName("AJ26YgMOzuiOxOIHelfUCIHXzES2RCBl9pK1jIeidMoXOyfbSD");
            corecontacts.setNativeTitle("0zhHkoeotKtIHJ24cZm9L5KZRKIQBd6L49cesxC95MiqaOitqn");
            corecontacts.setPhoneNumber("gxg7dljikwWxITBNYeaC");
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
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
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
