package salesdemo.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import salesdemo.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import salesdemo.app.server.repository.VillageRepository;
import salesdemo.app.shared.location.Village;
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
import salesdemo.app.shared.location.Country;
import salesdemo.app.server.repository.CountryRepository;
import salesdemo.app.shared.location.District;
import salesdemo.app.server.repository.DistrictRepository;
import salesdemo.app.shared.location.Region;
import salesdemo.app.server.repository.RegionRepository;
import salesdemo.app.shared.location.State;
import salesdemo.app.server.repository.StateRepository;
import salesdemo.app.shared.location.Taluka;
import salesdemo.app.server.repository.TalukaRepository;

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
            country.setCapital("jRx4YHxB5yuwOrSOcFdi85PHwpXsEmhQ");
            country.setCapitalLatitude(7);
            country.setCapitalLongitude(3);
            country.setCountryCode1("V2P");
            country.setCountryCode2("Fi1");
            country.setCountryFlag("uDgyVdK9lNOFIhp7JiDSRHloaYD4C6AIDIVDaOaI5aB2xztfKz");
            country.setCountryName("PQaIbSRmpn8ix6ghyCt3Wp1zj9joaZAg4kIyxNdtqwIFytM72i");
            country.setCurrencyCode("gpN");
            country.setCurrencyName("wM8X1NK37GFgWHPy96jqcfF2Tmj7GBJW4krhCsorRTybFiO1EU");
            country.setCurrencySymbol("Swxe0uABRzDlk8f81Fxfuj5LSPoaEgAg");
            country.setIsoNumeric(2);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            District district = new District();
            district.setCode2("KBuPV98i9y7JgbXmZdriafdyseiIP6bY");
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("dFH4KIgl4LWgqXf4H0RYFMoBMZliIvG8bXp9gMKtn3iqatFgwG");
            state.setStateCapitalLatitude(10);
            state.setStateCapitalLongitude(4);
            state.setStateCode(2);
            state.setStateCodeChar2("UuaBDtASJBO7aAwyAa8w4Fk1HmnEF3I4");
            state.setStateCodeChar3("jyhEDUl7ZubLQouWd9mrxdIPZ2NtOptS");
            state.setStateDescription("0LWd40W8ZWlp0tuaJtIp23Qz9eExnrojVNmORp6kgUYDTyB49Z");
            state.setStateFlag("HWMz6ObNST9avL9JjFvUzACgvNqTgZv5rQPHfDJpu1KzA2c7Rm");
            state.setStateName("9ItrF8oPcWtYG7KJYa61T8lZLQlps5EF090tvfhtww14Ik1lsR");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(2);
            region.setRegionCodeChar2("zX9kuUY7Z8bUATCWMl4WycDsvk2BnvFr");
            region.setRegionDescription("kEQWmUNU0v9ZqcZI8Jxz52AcOVwz8QMeVEZpZ2lmm4fkaSZ1fp");
            region.setRegionFlag("FY6JaTwqelnv4RkVK3SY2sFqJWR8N7Dp6DyiiCfbDdno8ZkoRP");
            region.setRegionLatitude(7);
            region.setRegionLongitude(1);
            region.setRegionName("SmT1X6gLHK6kjWYZ1XL7bZLSr5M0jZ6v0b5277IKzj5Vhhgzpq");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            district.setCode2("bveI6SzqzwHMdnPqRPiyPb81vsScelzK");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("8UG8paUDX12igltNvLTfQog439Momid17IzGVnv7AXHfjGkZvh");
            district.setDistrictFlag("hOILpkYrfAtNhISjofb02GDBzYq3hVbbbQ9DEnKusnONVtM5Sr");
            district.setDistrictLatitude(6);
            district.setDistrictLongitude(3);
            district.setName("gKqGYDw8xlTlq1uDWDwZqSUWIQcwHer2XIJNbmF6zS9PJdL4Et");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            District DistrictTest = districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
            Taluka taluka = new Taluka();
            taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setTalukaCode("LlXUKhR3twZatsiqYRceJ6AGbKPSA0qA");
            taluka.setTalukaDescription("TiPNVQhV7enJYhuhV8VZ6R3wRgTkD2ZJvRsOy5gd4CgezeZtnp");
            taluka.setTalukaFlag("ggC0hHchVIlzpqbCg0Fyjn6HHbNZmd62rRqEWeUJfwGahdujts");
            taluka.setTalukaLatitude(1);
            taluka.setTalukaLongitude(1);
            taluka.setTalukaName("TmAL4AYtwIiRgp2DGlWfyfN1U8vSxP7ziB8GDyNeucEAVLhlGG");
            Taluka TalukaTest = talukaRepository.save(taluka);
            map.put("TalukaPrimaryKey", taluka._getPrimarykey());
            Village village = new Village();
            village.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setTalukaaId((java.lang.String) TalukaTest._getPrimarykey());
            village.setVillageCode("LKNOHR7fhSUIoRg9SPFOqDsRU4XvshCf");
            village.setVillageDescription("QQUh3Bc8jTo5FwOv8X5BNQMenfAg4xRBVeoM2oL6D8i26DGRjC");
            village.setVillageFlag("IkD5ARgY9nTCTeYsRwkuSj80TEHqcuPU2K21b5mAGIZIW6bn0I");
            village.setVillageLatitude("JrQikPXDO3A");
            village.setVillageLongtitude(11);
            village.setVillageName("u4EWUQIfEiQXFmjPHbv7BjbBlCsQyf31txRDRlv6jsEhxQoQFY");
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
            village.setVillageCode("MzyuNtCJvO8MOmxF9Q8ziK1DyZ58AFOJ");
            village.setVillageDescription("ujqksXrbDGggayCOMnXYhGqctp84thCnvLppCrAPbud7tt2OOm");
            village.setVillageFlag("jdk4coO2ai1kb3VmRIzFfFM8OPbPVTRVqEfmHW8lQmXUvUInoN");
            village.setVillageLatitude("juWHltGn2KK");
            village.setVillageLongtitude(6);
            village.setVillageName("IdXHVSnbBFzkWkwPwwN2i5AV4cGGyHrpwtUQC5N8xHb8pUAf8p");
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
