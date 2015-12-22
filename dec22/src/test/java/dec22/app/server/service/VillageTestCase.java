package dec22.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import dec22.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import dec22.app.server.repository.VillageRepository;
import dec22.app.shared.location.Village;
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
import dec22.app.shared.location.Country;
import dec22.app.server.repository.CountryRepository;
import dec22.app.shared.location.District;
import dec22.app.server.repository.DistrictRepository;
import dec22.app.shared.location.Region;
import dec22.app.server.repository.RegionRepository;
import dec22.app.shared.location.State;
import dec22.app.server.repository.StateRepository;
import dec22.app.shared.location.Taluka;
import dec22.app.server.repository.TalukaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class VillageTestCase {

    @Autowired
    private VillageRepository<Village> villageRepository;

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
            Country country = new Country();
            country.setCapital("msl061ddRiaDQU3AGUXjJY7E0kw6KVRx");
            country.setCapitalLatitude(4);
            country.setCapitalLongitude(11);
            country.setCountryCode1("6JQ");
            country.setCountryCode2("5d5");
            country.setCountryFlag("9wphFU7gIsUs63NxC0IEMRKBA2rLpNPcAf40DvMsUMPb1jYRCz");
            country.setCountryName("aYQAhT9ofzBu4HW4gaFLqO7WcHy7gGr1pa9uiFc5nBFaUGt0bM");
            country.setCurrencyCode("RPk");
            country.setCurrencyName("Qjkq5ejUq72cyKqMqNKpMWV3IlqBuSp8X4fxGNvvyULMMG364o");
            country.setCurrencySymbol("Q2tZtMDQx5TEri76D1YWnLYUkJDem5pt");
            country.setIsoNumeric(0);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            District district = new District();
            district.setCode2("ZPdiHft326n9gjY99H4OIWiQ22qsbtTp");
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("ujuFoMBz8X0JkZhqoyCy8DkpQ7k1yfeGPpC90Km1dFHhjnn7hC");
            state.setStateCapitalLatitude(0);
            state.setStateCapitalLongitude(4);
            state.setStateCode(1);
            state.setStateCodeChar2("9wH8aIb5e67vptjhCHLcfObczldcAqB3");
            state.setStateCodeChar3("mBkfzYqnqcMYE6gP8tai8KxQcInW3CEz");
            state.setStateDescription("nTM7oit8OkNj45ztqhafS293O2RlLiFpKtb2B2RZ2Qj2bB2xVn");
            state.setStateFlag("ggGFXtJQyn9Qgwm8o7BW8ge5k5OtFen8398CdGoeDD1hpk8uOk");
            state.setStateName("jNELL12JwSyuQKOD9M3rpZSP4pSjCw2KvDmkU6yDHd3Y9AmWwc");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(1);
            region.setRegionCodeChar2("4nTy0M7VCksztnzQStiUMIAnuIneNehX");
            region.setRegionDescription("CJp9Yezkm7nrLSvRh7hnd99JahUwIaAHHjubQqbEepjIGrQy4H");
            region.setRegionFlag("xUWjOx2v6x3EAShhSmsfO7zqOS97BET2krQSCSLjMtphtDzz44");
            region.setRegionLatitude(1);
            region.setRegionLongitude(5);
            region.setRegionName("io9j5Pr6ewQDHBOz1lMrFRRTb30Eyz6swom7i1WVGVrvC8Kj8M");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            district.setCode2("8QVjZ882LY5SKbf1unHYkvimA9iFZwrQ");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("9Cbd5r80dhGVBVS1DUBzDsBXz3HhsPm9RjrlbHy5pf301aZ4VT");
            district.setDistrictFlag("fafRohJhoJozHQGSAAVrTMmIHywMfwSoEIodkvnL0THwinAWmS");
            district.setDistrictLatitude(7);
            district.setDistrictLongitude(7);
            district.setName("a3TxJs6AUVgCRymqdTTBFZVkEy3lmvXeQ26YmYefp36Qj9W3op");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            District DistrictTest = districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
            Taluka taluka = new Taluka();
            taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setTalukaCode("4SPxAknJ3N7RP0u7AuHnbhON2m0W9Ypz");
            taluka.setTalukaDescription("AXyk432lFN0xrOJVAMIez0GNrYDlMQ34yqkgh0MK0cYHFheoWs");
            taluka.setTalukaFlag("h6kVXWL39dAnPoLiDfsgcQQs7jBZy42eMZcAOdEpylFY16uwfV");
            taluka.setTalukaLatitude(11);
            taluka.setTalukaLongitude(8);
            taluka.setTalukaName("LwFKrgVh3gA26bOFw5eVcfSeIZAlK0Qu78B4ZGUFexLXksxunL");
            Taluka TalukaTest = talukaRepository.save(taluka);
            map.put("TalukaPrimaryKey", taluka._getPrimarykey());
            Village village = new Village();
            village.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setTalukaaId((java.lang.String) TalukaTest._getPrimarykey());
            village.setVillageCode("lbPYTySKb7TbcEQUunEqoNfJFI7ZNGx9");
            village.setVillageDescription("w3yNWcSKvHI3Ud4zDuYVuuYGNgXkPhiNSApNr93QxfLi9Tbilc");
            village.setVillageFlag("UpHWO7SQyjtQOCtOUdCjmPncyJlIbhRiUvXw8fSv4Danq7eaHJ");
            village.setVillageLatitude("MaOtfwaMaiz");
            village.setVillageLongtitude(3);
            village.setVillageName("igRcGyVnquMXNKNRMEwehdvPk8cJS7hXqcWLt0z4pn0EHXwLH2");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            village.setEntityValidator(entityValidator);
            village.isValid();
            villageRepository.save(village);
            map.put("VillagePrimaryKey", village._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private DistrictRepository<District> districtRepository;

    @Autowired
    private RegionRepository<Region> regionRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private TalukaRepository<Taluka> talukaRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            Village village = villageRepository.findById((java.lang.String) map.get("VillagePrimaryKey"));
            village.setVersionId(1);
            village.setVillageCode("9y7cVOzVbSY9W8QmbOPxRomxkVFhKwRp");
            village.setVillageDescription("8FlzYMkXYu8sLZn5VNXmp5Nl1E4UCjbXC4RKE0A9p1e5df7D8L");
            village.setVillageFlag("7D904QB9bzYUD0cTjhbjATIPWPuLUDB8zcd4ZgjoO1TdCzVIi6");
            village.setVillageLatitude("8x6BYPRF9nV");
            village.setVillageLongtitude(10);
            village.setVillageName("WGX7gSKeuZ4r6A5rzW9o0l1XmmJXNAgdI0afNGD0pqtIOV8KRa");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            villageRepository.update(village);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Village> listofcountryId = villageRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
    public void test3findBydistrictId() {
        try {
            java.util.List<Village> listofdistrictId = villageRepository.findByDistrictId((java.lang.String) map.get("DistrictPrimaryKey"));
            if (listofdistrictId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByregionId() {
        try {
            java.util.List<Village> listofregionId = villageRepository.findByRegionId((java.lang.String) map.get("RegionPrimaryKey"));
            if (listofregionId.size() == 0) {
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
            java.util.List<Village> listofstateId = villageRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
    public void test3findBytalukaaId() {
        try {
            java.util.List<Village> listoftalukaaId = villageRepository.findByTalukaaId((java.lang.String) map.get("TalukaPrimaryKey"));
            if (listoftalukaaId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            villageRepository.findById((java.lang.String) map.get("VillagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            villageRepository.delete((java.lang.String) map.get("VillagePrimaryKey")); /* Deleting refrenced data */
            talukaRepository.delete((java.lang.String) map.get("TalukaPrimaryKey")); /* Deleting refrenced data */
            districtRepository.delete((java.lang.String) map.get("DistrictPrimaryKey")); /* Deleting refrenced data */
            regionRepository.delete((java.lang.String) map.get("RegionPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
