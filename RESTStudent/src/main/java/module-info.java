module fr.insa.soa.RESTStudent.module {
    requires jakarta.ws.rs;

    requires org.glassfish.jersey.container.servlet;
    requires org.glassfish.jersey.inject.hk2;

    exports fr.insa.soa.RESTStudent;
}