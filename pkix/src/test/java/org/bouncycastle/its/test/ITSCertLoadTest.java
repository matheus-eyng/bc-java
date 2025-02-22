package org.bouncycastle.its.test;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

import junit.framework.TestCase;
import org.bouncycastle.util.encoders.Hex;

public class ITSCertLoadTest
    extends TestCase
{
    private static final String[] certNames = new String[]{
        "CERT_IUT_A1_AT.oer",
        "CERT_IUT_A2_AT.oer",
        "CERT_IUT_A3_AT.oer",
        "CERT_IUT_A4_AT.oer",
        "CERT_IUT_A_AA.oer",
        "CERT_IUT_A_AA_A8.oer",
        "CERT_IUT_A_AT.oer",
        "CERT_IUT_A_AT_A8.oer",
        "CERT_IUT_A_B33_AT.oer",
        "CERT_IUT_A_B3_AA.oer",
        "CERT_IUT_A_B3_AT.oer",
        "CERT_IUT_A_B3_N_AT.oer",
        "CERT_IUT_A_B_AA.oer",
        "CERT_IUT_A_B_AT.oer",
        "CERT_IUT_A_B_N_AT.oer",
        "CERT_IUT_A_N_AA.oer",
        "CERT_IUT_A_N_AT.oer",
        "CERT_IUT_A_RCA.oer",
        "CERT_IUT_B_AT.oer",
        "CERT_IUT_C1_AT.oer",
        "CERT_IUT_C3_AA.oer",
        "CERT_IUT_CA1_AT.oer",
        "CERT_IUT_CA2_AT.oer",
        "CERT_IUT_CA3_AT.oer",
        "CERT_IUT_CAM_BO_02_AT.oer",
        "CERT_IUT_CAM_BO_03_AT.oer",
        "CERT_IUT_CA_AA.oer",
        "CERT_IUT_CC_AA.oer",
        "CERT_IUT_C_AT.oer",
        "CERT_IUT_C_AT_8.oer",
        "CERT_IUT_C_RCA.oer",
        "CERT_IUT_DENM_BO_01_AT.oer",
        "CERT_IUT_DENM_BO_02_AT.oer",
        "CERT_IUT_D_AT.oer",
        "CERT_IUT_D_AT_8.oer",
        "CERT_IUT_E_AT.oer",
        "CERT_IUT_E_AT_8.oer",
        "CERT_TS_AA_AUTHVAL_RCV_02_BI_01.oer",
        "CERT_TS_AA_AUTHVAL_RCV_02_BI_02.oer",
        "CERT_TS_AA_AUTHVAL_RCV_02_BI_03.oer",
        "CERT_TS_A_AA.oer",
        "CERT_TS_A_AA_B.oer",
        "CERT_TS_A_AT.oer",
        "CERT_TS_A_EA.oer",
        "CERT_TS_A_EA_AA_AUTHVAL_RCV_02_BI_01.oer",
        "CERT_TS_A_EA_AA_AUTHVAL_RCV_02_BI_02.oer",
        "CERT_TS_A_EA_AA_AUTHVAL_RCV_02_BI_03.oer",
        "CERT_TS_A_EC.oer",
        "CERT_TS_B1_AT.oer",
        "CERT_TS_B_AT.oer",
        "CERT_TS_CAM_BO_02_AT.oer",
        "CERT_TS_CAM_BO_03_AT.oer",
        "CERT_TS_DENM_BO_01_AT.oer",
        "CERT_TS_DENM_BO_02_AT.oer",
        "CERT_TS_EC_ENR_RCV_02_BI_01.oer",
        "CERT_TS_EC_ENR_RCV_02_BI_02.oer",
        "CERT_TS_EC_ENR_RCV_02_BI_03.oer",
        "CERT_TS_F_AT.oer"
    };

    private static final String certContentRoot = "/org/bouncycastle/its/certs";


//    public void test()
//        throws Exception
//    {
//        String path = "/org/bouncycastle/its/certs/CERT_IUT_C3_AA.oer";
//        byte[] data = Streams.readAll(this.getClass().getResourceAsStream(path));
//        System.out.println(Hex.toHexString(data));
//
//        OERInputStream oerInputStream = new OERInputStream(new HexIn(new ByteArrayInputStream(data)))
//        {
//            {
//                this.debugOutput = new PrintWriter(System.out);
//            }
//        };
//
//        ASN1Object obj = oerInputStream.parse(IEEE1609dot2.certificate);
//
//        ITSCertificate certificate = new ITSCertificate(Certificate.getInstance(obj));
//
//        System.out.println();
//
//    }

/*
    public void testLoadAllCerts()
        throws Exception
    {
        for (String name : certNames)
        {
            String path = certContentRoot + "/" + name;
            InputStream src = this.getClass().getResourceAsStream(path);
            if (src == null)
            {
                throw new IllegalStateException("Unable to find test cert: " + path);
            }


            try
            {
                OERInputStream oerIn = new OERInputStream(src);
                ASN1Object obj = oerIn.parse(IEEE1609dot2.certificate);
                ITSCertificate certificate = new ITSCertificate(Certificate.getInstance(obj));


                System.out.println("ok");
            }
            catch (Exception ex)
            {
                System.out.println("Unable to read: " + path);
                throw ex;
            }

        }
    }

    */

    static class HexIn
        extends FilterInputStream
    {

        /**
         * Creates a {@code FilterInputStream}
         * by assigning the  argument {@code in}
         * to the field {@code this.in} so as
         * to remember it for later use.
         *
         * @param in the underlying input stream, or {@code null} if
         *           this instance is to be created without an underlying stream.
         */
        protected HexIn(InputStream in)
        {
            super(in);
        }

        @Override
        public int read()
            throws IOException
        {
            int r = super.read();
            System.out.println(Hex.toHexString(new byte[]{(byte)(r & 0xFF)}));
            return r;
        }

        @Override
        public int read(byte[] b)
            throws IOException
        {

            int i = super.read(b);
            System.out.println(Hex.toHexString(b));
            return i;
        }

        @Override
        public int read(byte[] b, int off, int len)
            throws IOException
        {
            int i = super.read(b, off, len);

            System.out.println(Hex.toHexString(b, off, i));
            return i;

        }
    }

}
