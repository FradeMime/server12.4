/*
 * Copyright 2013-2020 Signal Messenger, LLC
 * SPDX-License-Identifier: AGPL-3.0-only
 */

package org.whispersystems.textsecuregcm.workers;

import io.dropwizard.core.cli.Command;
import io.dropwizard.core.setup.Bootstrap;
import java.util.Base64;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import org.signal.libsignal.zkgroup.GenericServerSecretParams;
import org.signal.libsignal.zkgroup.ServerPublicParams;
import org.signal.libsignal.zkgroup.ServerSecretParams;

public class ZkParamsCommand extends Command {

  public ZkParamsCommand() {
    super("zkparams", "Generates server zkparams");
  }

  @Override
  public void configure(Subparser subparser) {

  }

  @Override
  public void run(Bootstrap<?> bootstrap, Namespace namespace) throws Exception {
    ServerSecretParams serverSecretParams = ServerSecretParams.generate();
    ServerPublicParams serverPublicParams = serverSecretParams.getPublicParams();

    System.out.println("zkConfig Public: " + Base64.getEncoder().withoutPadding().encodeToString(serverPublicParams.serialize()));
    System.out.println("zkConfig Private: " + Base64.getEncoder().withoutPadding().encodeToString(serverSecretParams.serialize()));

//    cql 加
    //   生成  calling backup的secret params
    System.out.println("==============================cql加=================================================");
    GenericServerSecretParams newCallingzksecretParams = GenericServerSecretParams.generate();
    System.out.println("cqlCalling Secret: " + Base64.getEncoder().withoutPadding().encodeToString(newCallingzksecretParams.serialize()));
    GenericServerSecretParams newBackupzksecretParams = GenericServerSecretParams.generate();
    System.out.println("cqlBackup Secret: " + Base64.getEncoder().withoutPadding().encodeToString(newBackupzksecretParams.serialize()));



  }

}
