package dec22.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import dec22.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import dec22.app.server.repository.TalukaRepository;
import dec22.app.shared.location.Taluka;
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
            country.setCapital("t5YnOWRaXCTk5cwnYQIcd2oTA0Gug2ub");
            country.setCapitalLatitude(11);
            country.setCapitalLongitude(2);
            country.setCountryCode1("fo4");
            country.setCountryCode2("Yvk");
            country.setCountryFlag("jhnbiIc0klG4Q7CryNs30G2NLZIcuWchDTssHPsjCut6e0EFKY");
            country.setCountryName("bxuCM1YRZcor5FIs1g1scZdkBHBbRMMB0nsWabpJyY11kvMCLk");
            country.setCurrencyCode("Wmc");
            country.setCurrencyName("5QqT21B5aj4oIzZgPR85GfXdP2XKvKRqgsN7CgWBXU1G8tTRCg");
            country.setCurrencySymbol("KXtWmUMf0dgfTZOqgn5GsknNxnYiw9ml");
            country.setIsoNumeric(6);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            District district = new District();
            district.setCode2("7dvQAo2O4Z4nPwuWfSQxPxGDJ92Ixb65");
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("O4nLR42IAoU8OPMfjQrellQZt6wFisXMBnKSppElv8bxOYpcsY");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(1);
            state.setStateCode(2);
            state.setStateCodeChar2("GglmRJ3LH8E795LFHX7PGcCUesSD4FLa");
            state.setStateCodeChar3("6i3ib6jvMdFvudvXMv07taxBNc6eBAgY");
            state.setStateDescription("0LF70IVJBLxbRDCCNkSvtKz1gFr3f9uiT6RFDwlpkNGKtKwXOB");
            state.setStateFlag("NkMyfmZO4ILEsbpaVV1u4oFrCQt4OSifirvljlwXntWkgpCwtg");
            state.setStateName("zUEuSIrdhCCdpRuQ4zvahIsbDDMcyA8RuQprrcAG6gywYMfZNu");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(2);
            region.setRegionCodeChar2("X1IBuEosEdYbPUqd3emD4QzvOKx1ZxUa");
            region.setRegionDescription("sWiefkTqO7R8YRtBtZsSNvOHskgSkPUrP9MBzrMUlHKRdazaxz");
            region.setRegionFlag("W0hTXHn0eq2mm2FlpP0nbkDlrbOLkx7DcrbGZpgfIGcweqxK4H");
            region.setRegionLatitude(11);
            region.setRegionLongitude(8);
            region.setRegionName("boGFxz23cY5xMYyGEE3MLvOT5ez4H3167YOrnvdLtisgd4zWfd");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            district.setCode2("OxGy5df22Cu6RFTxC3ZSPT2DGr7pj5OS");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("KqZkqDnuAxmUfLpTImdzCZ9SAxQoSlsnjFD737cKez5ocNIGIM");
            district.setDistrictFlag("iCgcZPv2CNQnIislBglfvtJnvaBAWezaBV7CKNUjMwADAN2bcc");
            district.setDistrictLatitude(6);
            district.setDistrictLongitude(3);
            district.setName("WU6gBjxQoodOP16kPZgFAMdLi6qlzXPDsO64e1HABfxtw4cs8q");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            District DistrictTest = districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
            Taluka taluka = new Taluka();
            taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setStateId((java.lang.String) StateTest._getPrimarykey());
            taluka.setTalukaCode("eVpquwn7XjDzvKtQ4KgHR7X91YvHWFAR");
            taluka.setTalukaDescription("rJlDAOhcHIfgyIVGeDpvrYhUYIHw9amNKijkmiEmn3k3VafIz0");
            taluka.setTalukaFlag("juRPYZBJKwrOJUZOOnrljBjXskIC6TVhsfBZ1BgD9cplBVEGNy");
            taluka.setTalukaLatitude(7);
            taluka.setTalukaLongitude(11);
            taluka.setTalukaName("WSwwtUBeVb4nPcPsXtipIkCsBzlSiYI97HIxkQEJGAQMSsiOAo");
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
            taluka.setTalukaCode("UxHUPqGdE6eEQfUjjiYN80Qqsr2kY03g");
            taluka.setTalukaDescription("8vdPAVSvRxS4xSArc6gW7IlRvUPgHvdMnaVSSTH9h2g79Vc7Z6");
            taluka.setTalukaFlag("BRoP4FXPIGvIclWRmgpF0OpKbfatYWxMP2LKQ6dmfcE5mgdGsn");
            taluka.setTalukaLatitude(8);
            taluka.setTalukaLongitude(9);
            taluka.setTalukaName("SoYX6BZ0gPRN8TUsSSrCi3U4OJ8N4k93Kq0GU7INDjdtHJMbly");
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
