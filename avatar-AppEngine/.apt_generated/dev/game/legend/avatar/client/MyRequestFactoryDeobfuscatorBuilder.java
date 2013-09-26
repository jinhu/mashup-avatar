// Automatically Generated -- DO NOT EDIT
// dev.game.legend.avatar.client.MyRequestFactory
package dev.game.legend.avatar.client;
import java.util.Arrays;
import com.google.web.bindery.requestfactory.vm.impl.OperationData;
import com.google.web.bindery.requestfactory.vm.impl.OperationKey;
public final class MyRequestFactoryDeobfuscatorBuilder extends com.google.web.bindery.requestfactory.vm.impl.Deobfuscator.Builder {
{
withOperation(new OperationKey("W3rKi0_qqytiqqdSxtisscvU7dc="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/InstanceRequest;")
  .withDomainMethodDescriptor("()Ljava/lang/String;")
  .withMethodName("send")
  .withRequestContext("dev.game.legend.avatar.client.MyRequestFactory$MessageRequest")
  .build());
withOperation(new OperationKey("XJ6$pkLb2$_TSzhBvzQ93mOhig8="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("()Ljava/lang/String;")
  .withMethodName("getMessage")
  .withRequestContext("dev.game.legend.avatar.client.MyRequestFactory$HelloWorldRequest")
  .build());
withOperation(new OperationKey("UDYwLRNq0E1NfGPle1Dx_tnwd$M="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/InstanceRequest;")
  .withDomainMethodDescriptor("()V")
  .withMethodName("register")
  .withRequestContext("dev.game.legend.avatar.client.MyRequestFactory$RegistrationInfoRequest")
  .build());
withOperation(new OperationKey("BBS1EKQXbxHMS9jeMknnqwsAddc="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/InstanceRequest;")
  .withDomainMethodDescriptor("()V")
  .withMethodName("unregister")
  .withRequestContext("dev.game.legend.avatar.client.MyRequestFactory$RegistrationInfoRequest")
  .build());
withRawTypeToken("8KVVbwaaAtl6KgQNlOTsLCp9TIU=", "com.google.web.bindery.requestfactory.shared.ValueProxy");
withRawTypeToken("FXHD5YU0TiUl3uBaepdkYaowx9k=", "com.google.web.bindery.requestfactory.shared.BaseProxy");
withRawTypeToken("zL46nLzStnYbMillqyc7J7pzxl4=", "dev.game.legend.avatar.shared.MessageProxy");
withRawTypeToken("mA16ZOJ_3koC7IhPGRa2phxnJ1g=", "dev.game.legend.avatar.shared.RegistrationInfoProxy");
withClientToDomainMappings("dev.game.legend.avatar.server.Message", Arrays.asList("dev.game.legend.avatar.shared.MessageProxy"));
withClientToDomainMappings("dev.game.legend.avatar.server.RegistrationInfo", Arrays.asList("dev.game.legend.avatar.shared.RegistrationInfoProxy"));
}}
