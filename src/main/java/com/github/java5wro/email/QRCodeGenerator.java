package com.github.java5wro.email;

import java.io.*;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import sun.misc.IOUtils;

public class QRCodeGenerator {

public byte[] QrGenerator (String uuid){

    ByteArrayOutputStream stream = QRCode.from(uuid).withSize(250, 250).stream();




return stream.toByteArray();

}
}