package salesdemo.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import salesdemo.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import salesdemo.app.server.repository.TalukaRepository;
import salesdemo.app.shared.location.Taluka;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class TalukaTestCase {

    @Autowired
    private TalukaRepository<Taluka> talukaRepository;

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
            country.setCapital("QOFxdMylaKIlUKcsloCsnbSSRl1xGDQq");
            country.setCapitalLatitude(4);
            country.setCapitalLongitude(11);
            country.setCountryCode1("9i8");
            country.setCountryCode2("SxN");
            country.setCountryFlag("XDaGkcPSFqr77X1eFEW4C2EX49gluBW3Obiv5aL9h3E20aHN6U");
            country.setCountryName("CwbPh4oFBMyxfEUqG9RetZJf7DwOVm9RQhAXbzE4AxquuR7zFC");
            country.setCurrencyCode("Tgd");
            country.setCurrencyName("wfamY2K4UCcJVPVj4pVAj71UORqWQuOUVZnD3YBqCNFp7lUTNu");
            country.setCurrencySymbol("2ET0TD2j4KPHRO9QJRITN3qxZxGBKKB4");
            country.setIsoNumeric(9);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            District district = new District();
            district.setCode2("Xkh51b91xQkCPKW9IejWxRGEyHxkjxEW");
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("Qz6dcNZDgkEFI1OFT9V3bTbCKlC73wMsSVB4TFmCmUx5OUUVzZ");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(2);
            state.setStateCode(0);
            state.setStateCodeChar2("W45DB5gyzj4xhtvo3y5s3Ak2k9lqdv0X");
            state.setStateCodeChar3("YHwinZ2ec8I6RNcOS6QankOiozAM2ccC");
            state.setStateDescription("Ay6JQoGz18QMyqETBIZ6EFqa0Npu5l0EQrkTnjeGgBoDuze5JI");
            state.setStateFlag("WtnafGN7tUtp3ZuPL4aNRKUyR0SpqsCZTX9bPXan78UWWCVUXX");
            state.setStateName("oVgvOPq096Z2yT3dwfJPqyvtM4UJCoxplH0mQWF8I5TYfJGRIz");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(2);
            region.setRegionCodeChar2("IXimR2Y5fcSQ0BXzldfqCNRJrM5qQFt8");
            region.setRegionDescription("YcgOa5Tr4O5mgfMLkfErzfalAtSzgArASGjVPgwh3h96RHrnIc");
            region.setRegionFlag("qX3bVbwmhpgE4PQvBxGQGtDqoPegMpQ7DnpRZtAIW8JNTt2Hj2");
            region.setRegionLatitude(6);
            region.setRegionLongitude(11);
            region.setRegionName("WmFGlOcwcTuzGp6TLtPZGRrHuA5KtCBPIUE1XFJ1NHzn4DXKUH");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            district.setCode2("4cQxYyLVvd2cWzu0P3VpZ600AZWOmpOT");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("jrqNjFZzbHpu5GSsH5ub6bL0wtNY2XcQTr9bTS5YRhlgKdMIgk");
            district.setDistrictFlag("hv6kcmGylHunN9idqct2ow6gWXQXCxDDlJ6lfuduwwhmDoL0Y7");
            district.setDistrictLatitude(4);
            district.setDistrictLongitude(0);
            district.setName("qlRDOMygcSG5AKmGsyUCvrXPnSsoZg67zZaKlbHCfuIMhlHrFt");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            District DistrictTest = districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
            Taluka taluka = new Taluka();
            taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setStateId((java.lang.String) StateTest._getPrimarykey());
            taluka.setTalukaCode("bY1jDd7ML9JF1XENOX09s5rhO42h7skH");
            taluka.setTalukaDescription("mKg3nNEX9J22uiI22410Jww1jgk3Ds3jSFtE3mm0hAWoUkLaS2");
            taluka.setTalukaFlag("JW2lkv2kXHidVkI0ciNDYQQ55i4AhzXjKi313L5IPPRF5idr1p");
            taluka.setTalukaLatitude(1);
            taluka.setTalukaLongitude(6);
            taluka.setTalukaName("HYHtX4qMGHVdRqnGcHMVXTzabFytueDOh4PouQdO6o0N36DQH0");
            taluka.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            taluka.setEntityValidator(entityValidator);
            taluka.isValid();
            talukaRepository.save(taluka);
            map.put("TalukaPrimaryKey", taluka._getPrimarykey());
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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TalukaPrimaryKey"));
            Taluka taluka = talukaRepository.findById((java.lang.String) map.get("TalukaPrimaryKey"));
            taluka.setTalukaCode("M2RpF74j6pyBz0xprcqTUOcUQqvOUyo1");
            taluka.setTalukaDescription("7eSSjcmI3G8CF4j5Nh5VCJ4P2fyrWKOcozXwPTbHqW5jwcjJu0");
            taluka.setTalukaFlag("IeQAUciMORUPq2l6eHTA5FADf5wwWGRS3402yD5yUTauIkFeoX");
            taluka.setTalukaLatitude(9);
            taluka.setTalukaLongitude(3);
            taluka.setTalukaName("51rUPfACZusU4j76enDmgKxzK6LxmO7PLxu3OSBQqHU4GYRgBp");
            taluka.setVersionId(1);
            taluka.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            talukaRepository.update(taluka);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Taluka> listofcountryId = talukaRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            java.util.List<Taluka> listofdistrictId = talukaRepository.findByDistrictId((java.lang.String) map.get("DistrictPrimaryKey"));
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
            java.util.List<Taluka> listofregionId = talukaRepository.findByRegionId((java.lang.String) map.get("RegionPrimaryKey"));
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
            java.util.List<Taluka> listofstateId = talukaRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TalukaPrimaryKey"));
            talukaRepository.findById((java.lang.String) map.get("TalukaPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TalukaPrimaryKey"));
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
