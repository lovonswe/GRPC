// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user.proto

package com.nahid.grpc;

public final class User {
  private User() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RegistrationRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RegistrationRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_LoginRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LoginRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_APIResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_APIResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Empty_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nuser.proto\"o\n\023RegistrationRequest\022\020\n\010f" +
      "ullName\030\001 \001(\t\022\020\n\010userName\030\002 \001(\t\022\023\n\013phone" +
      "Number\030\003 \001(\t\022\r\n\005email\030\004 \001(\t\022\020\n\010password\030" +
      "\005 \001(\t\"2\n\014LoginRequest\022\020\n\010username\030\001 \001(\t\022" +
      "\020\n\010password\030\002 \001(\t\"<\n\013APIResponse\022\027\n\017resp" +
      "onseMessage\030\001 \001(\t\022\024\n\014responseCode\030\002 \001(\005\"" +
      "\007\n\005Empty2\200\001\n\004user\0222\n\014registration\022\024.Regi" +
      "strationRequest\032\014.APIResponse\022$\n\005login\022\r" +
      ".LoginRequest\032\014.APIResponse\022\036\n\006logout\022\006." +
      "Empty\032\014.APIResponseB\022\n\016com.nahid.grpcP\001b" +
      "\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_RegistrationRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_RegistrationRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RegistrationRequest_descriptor,
        new java.lang.String[] { "FullName", "UserName", "PhoneNumber", "Email", "Password", });
    internal_static_LoginRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_LoginRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_LoginRequest_descriptor,
        new java.lang.String[] { "Username", "Password", });
    internal_static_APIResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_APIResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_APIResponse_descriptor,
        new java.lang.String[] { "ResponseMessage", "ResponseCode", });
    internal_static_Empty_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Empty_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
