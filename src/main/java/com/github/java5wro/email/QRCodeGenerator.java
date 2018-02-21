package com.github.java5wro.email;

import java.io.*;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import sun.misc.IOUtils;

public class QRCodeGenerator {

public ByteArrayInputStream QrGenerator (String uuid){

    ByteArrayOutputStream stream = QRCode.from(uuid).stream();

    ByteArrayInputStream qrCode = new ByteArrayInputStream(stream.toByteArray());


return qrCode;

}
}