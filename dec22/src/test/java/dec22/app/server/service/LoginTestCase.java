package dec22.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import dec22.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import dec22.app.server.repository.LoginRepository;
import dec22.app.shared.authentication.Login;
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
import dec22.app.shared.contacts.CoreContacts;
import dec22.app.server.repository.CoreContactsRepository;
import dec22.app.shared.contacts.Gender;
import dec22.app.server.repository.GenderRepository;
import dec22.app.shared.location.Language;
import dec22.app.server.repository.LanguageRepository;
import dec22.app.shared.location.Timezone;
import dec22.app.server.repository.TimezoneRepository;
import dec22.app.shared.contacts.Title;
import dec22.app.server.repository.TitleRepository;
import dec22.app.shared.authentication.User;
import dec22.app.server.repository.UserRepository;
import dec22.app.shared.authentication.UserAccessDomain;
import dec22.app.server.repository.UserAccessDomainRepository;
import dec22.app.shared.authentication.UserAccessLevel;
import dec22.app.server.repository.UserAccessLevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(62);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("m3cKlzn4pSr0mBSgRpT5d0OLwNXnIIGpeYhhKllm71DM9tHgdE");
            corecontacts.setFirstName("ziHanqNBB7NrlaNDEOpvIwtLtEvXyHCWBE3lgzBH9eGPdEcYjt");
            Gender gender = new Gender();
            gender.setGender("9s6AJbGfBukkUQ9mMcKJ0inPRGF0zid4VY1ApnqxAEZeppIRMx");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("pv");
            language.setAlpha3("V3B");
            language.setAlpha4("cot4");
            language.setAlpha4parentid(5);
            language.setLanguage("nOuuzhGjNuHwH0f4PkMJhsuLqJ2KfFDdhsPPUWucQmIuiSSKUj");
            language.setLanguageDescription("DTLAqffOEfHYpomDP73WAbzYbdIe33ufQsyALTYbBHjc42g33O");
            language.setLanguageIcon("AwRoeEtdp4L6nbyZwS1kTkykhUMvZHbZy7yQfoAP4fnch8P1jV");
            language.setLanguageType("naRjdl3eqYKic62oCZ7dBGk8gnG9FjfS");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("gG2L9sczReusGmzzp7yaM7VFILnnhTU08LkpRCqq2JX15B5ZXx");
            timezone.setCountry("AZ7hLKSFKVl8kmrZfAJxypnJ3v1zmdwHIvvUtu9CvcM9bA8g9Z");
            timezone.setGmtLabel("rPeqsDQFrmCyqTpAJPUOLF3H5pawoU8TsB0iPLg884kw9vL4Yd");
            timezone.setTimeZoneLabel("VcECuEfJwc325uDgzzC323CNLvUYpHeWSLLppFSO1ehkcNOV89");
            timezone.setUtcdifference(8);
            Title title = new Title();
            title.setTitles("HvLjFGG1Cuh0Llgtd5UBBpooFOMnMzUsX5ZauyQm3jSpEFjBeY");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(49);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("tQeXCQ7CPtPUXKrcc1UrF1XZclV7XzQKcOEbIWUs9NQkTnZvbk");
            corecontacts.setFirstName("yiKtJJit5vmW8qH93XMKrsaElJXiwPv2qgcppD1QQvIn3nzKMl");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("3HNFukvFa3AHdSKx8Gvf9uGVAnEo32dC9BP7viOVpYSqdaazfL");
            corecontacts.setMiddleName("dd3kRbLjdnN8rYSKlo8aOB8N8y9ghQHIeFBHHLcQAchbtjzRVY");
            corecontacts.setNativeFirstName("p8F6N1oFMM63D7JJ2Mn9YgP1JWKJ3aUbFjC5Bom9LLBN0ZFY9K");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("Hf25IlYp98Uu84GjcvSrbsS8ippI6mWAi3kqwtfKoFvONw62C4");
            corecontacts.setNativeMiddleName("NoKuO54DAhMrH1BCs5DylqWMJxvTzLqK54vHEiECrQXacDfYp2");
            corecontacts.setNativeTitle("YnAX819W6MI8v3ogpqZILO3LDowHfJNBbZkliblvsTBsT4m1kK");
            corecontacts.setPhoneNumber("YfnorVe0uJmcGKyGQC6O");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("A0p8Zhc2h9sAAYGAiFsScGAdR9lGe37EtunvUOlfWeaSKQiIlb");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2742);
            user.setUserAccessCode(3);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("ZyCLStlV4Z8LhatAVdrQnjzQ3rLrielxogch8SdhAkeeeM7uCL");
            useraccessdomain.setDomainHelp("EJ5EJpAFK5IumV2Ua1Yovuve2I2fCnd1D4kEu8oDYY1N361hsa");
            useraccessdomain.setDomainIcon("phJev0oFkAVRDOZfB9fPJjvKKP0hdHyZjYwpKZcKNT079udNgA");
            useraccessdomain.setDomainName("3o3NZ3Qwd8NpFvwEfHasgyfPENLVH3cstgxIhkBaDI2Sx7ZH5Q");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("uBI2Mf5pOqsaC4iiscOHyZRFvYJdBvk7bv9NfR8hYFYPoIrw6f");
            useraccesslevel.setLevelHelp("0lkZuFx57QZX4iDRlYlSgtP2O0o2KQ5lWBNee30pYhXbMtXJxH");
            useraccesslevel.setLevelIcon("27yt8J4Yx4G4GnLCpISpoGmJPeb7VoBxgzNWwXBTCN10f5H61l");
            useraccesslevel.setLevelName("yIcPF14EQcp34tUIsC9C5DH1GD8Tpy8JhoS95T4nq2e7iuHgM7");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("1jLAvMV525F8OFVpjcHL0M7kuW0PwIrMn1tT4Ghpbb1QVCDjZC");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1693);
            user.setUserAccessCode(8);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(10);
            login.setIsAuthenticated(true);
            login.setLoginId("ldhAFT5XA2ckYKk2tj6eUJ1yvZmkkXksXV4qFpb9gMmMvewhJ5");
            login.setServerAuthImage("dMJi5V23TRn4cXyzY8M9waZY8A2aKAvP");
            login.setServerAuthText("ou4Tx7d60FtFgglH");
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(11);
            login.setLoginId("pcgsUpJZAIX4wfbNOaQ4aAtftCK9kFBDfOQ8QtP2CovERhlp93");
            login.setServerAuthImage("CVjaLTYQPeRubWbQHyoutikdNgI5ufnz");
            login.setServerAuthText("PL51VKleP4cZVndP");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
