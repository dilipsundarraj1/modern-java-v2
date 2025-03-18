module moduletwo {
    requires moduleone;
    //requires transitive com.moduleone;
    exports com.moduletwo.service;
    exports com.moduletwo.dtos;
    exports com.moduletwo.client;
}