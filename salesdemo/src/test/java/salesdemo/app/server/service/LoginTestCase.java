package salesdemo.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import salesdemo.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import salesdemo.app.server.repository.LoginRepository;
import salesdemo.app.shared.authentication.Login;
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
import salesdemo.app.shared.contacts.CoreContacts;
import salesdemo.app.server.repository.CoreContactsRepository;
import salesdemo.app.shared.contacts.Gender;
import salesdemo.app.server.repository.GenderRepository;
import salesdemo.app.shared.location.Language;
import salesdemo.app.server.repository.LanguageRepository;
import salesdemo.app.shared.location.Timezone;
import salesdemo.app.server.repository.TimezoneRepository;
import salesdemo.app.shared.contacts.Title;
import salesdemo.app.server.repository.TitleRepository;
import salesdemo.app.shared.authentication.User;
import salesdemo.app.server.repository.UserRepository;
import salesdemo.app.shared.authentication.UserAccessDomain;
import salesdemo.app.server.repository.UserAccessDomainRepository;
import salesdemo.app.shared.authentication.UserAccessLevel;
import salesdemo.app.server.repository.UserAccessLevelRepository;

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
            corecontacts.setAge(22);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("MYvmm8UOpjZs72dnBEL6tmFhwibHOOEdZy6Pv5hT7WvvnDOEHF");
            corecontacts.setFirstName("WHG7RrQq8WmcgeU23hrrE2Htvmq4JKVwkhLFiXFCKd6sCdGRb6");
            Gender gender = new Gender();
            gender.setGender("aOa3RHlgoqq5KurMcQrP3DZBhki6dP8B52Gy8M2yY9jbw0Z78B");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("lp");
            language.setAlpha3("eJp");
            language.setAlpha4("TRzH");
            language.setAlpha4parentid(5);
            language.setLanguage("d2SqZYiQyCLWfgxAhJL48anAGAz4xyyxRQHOx4Nng8mkoqDyr4");
            language.setLanguageDescription("TeDORwqRRsjG6I9fbNP5DHxV8BA5YE41tggJnLNd9AHTCjmnS1");
            language.setLanguageIcon("HjiKCfTK5QtngyHaKmKekUpmt08Y2REgsXmHc0frPYjqElyakB");
            language.setLanguageType("Pg3Vl0303gSTd2ArfvO3tcjlcX4pdK0R");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("iUiG6dsui0KerXlyqUM1O01hql5RVsfRa3833WogcC2JBpBs88");
            timezone.setCountry("6OrAgUh6H4PPCNcuKrPxCFIBUVTDGUYiXEncnOlKFAWWpSfuoI");
            timezone.setGmtLabel("kn8HG5wOD6hjpmeNobDrrZwTmCehpvBYGmSapEM2ZHrtGpNZIp");
            timezone.setTimeZoneLabel("ZqFEn4EoUbjWFid2L7OiNoMIUpmFAj1ErC0bVf9ROh5jmLL50P");
            timezone.setUtcdifference(11);
            Title title = new Title();
            title.setTitles("qapzuqvO8oXdIWClCcJ0JitdG6Xz4NF3UEpdOSdKdk9kLklu2x");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(0);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("tiXyHlPTA6LxsxdT4pbGXX7mzj5TfLgb6Nblh7XDE1Hfn83OZo");
            corecontacts.setFirstName("9TDGDbypTREpuNV2m0gQhr5KeUbKkI1oQQSciTix7tUvJyC5Ew");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("ED4X9OygFtyaSdFz1uk3wyyAeLOsfKtAtBE3VTY6J8mxVbrEdX");
            corecontacts.setMiddleName("Vll13nzDcBIcYe8NZxKxYsnek7DsQ72weh5049qlYnsjH04Kjz");
            corecontacts.setNativeFirstName("64uHyXRUmIFjZGlOMrUyoYBl0VZ7xxHXwmq6NtTXTAWOkHbHo9");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("YtDat1XuyInT9Tcqb326WWKuxpCQoON6zw3PCPUpx60rsSArlZ");
            corecontacts.setNativeMiddleName("79go2UeDN81Jpcb4sKEWewTDCx5j7UpixEREWGK7h4ycY43nNx");
            corecontacts.setNativeTitle("CTakGuQWytXEAvj3Vldb8qNQsPBvDOzKQOkHizp8zcOaRgV9Zu");
            corecontacts.setPhoneNumber("RLOjhWA28PwupfmPlAUv");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("o2QbSqiybfhfrFDihZv1TsCoOnd78izGeaKDthEDrj3hEh1DTE");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1721);
            user.setUserAccessCode(3);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("oXvphP1AU7XUqueArUnomv7rghSuVnJEMjHFIkXisud5MXKn6D");
            useraccessdomain.setDomainHelp("UiFoGt4XNG7IvzE18PVRO0vkdIA7oqEVuhbnR0c76QITfB6pGx");
            useraccessdomain.setDomainIcon("qCe14sVrWj1bOGAZT4PM7FbjnzsVnJxsTmrBT4Z6F0znRsCBlw");
            useraccessdomain.setDomainName("vPu5yKYcOHSXrMiVJz3qYX3beQ62Ufb8NCNfLqDlLkGPHfReu2");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("f9dK2J8B2CkgkEGt17oL0xYtfGpk0xjFYTvGgwsLgE78NbOO8E");
            useraccesslevel.setLevelHelp("hxJVAEyIjJbEpcp5RYjtP2nqEBGTBnpGRMkml05jUYeql2Nxyu");
            useraccesslevel.setLevelIcon("hFiq2OxAFO1HGLYLZa4Q7Qu8NZnujjGsGjDXE0pLI2Ofcjw6oY");
            useraccesslevel.setLevelName("dA4rzvN29OCLw4OEg1KdEUa9qgXRnTjBXBj8hDclRnNm0g7wT8");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("0mZt3zOmn6wTVfV7U1kLcBoZGPLeh0vkfKhYOX53Cjh6UgcNML");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(3541);
            user.setUserAccessCode(7);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(0);
            login.setIsAuthenticated(true);
            login.setLoginId("BoEGHhqysw6HMqlIYMLH4kC5tIJDA0oy5zFBmWK9wXttm4KbfU");
            login.setServerAuthImage("P2b3QiFtQfzs3ujSpQV5zQ21yCqAb6x9");
            login.setServerAuthText("PIO3OpnxayfbIBV5");
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
            login.setFailedLoginAttempts(4);
            login.setLoginId("X5EtPySOhfc7w4laZDyJ1n6VQHsH5SQsosOcwphk3giWlqjhfe");
            login.setServerAuthImage("En0Zfr403P68xbeSq63DCLZJvyZLebeD");
            login.setServerAuthText("PH6pL4LrUf3QzNDx");
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
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
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
