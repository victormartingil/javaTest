package main;

import main.testing.*;

import java.io.IOException;

public class Main {

    public static void main(String args[]) throws IOException {

        stream();
        
//        textContains();
//        substringThis();
//        doubleToString();
//        getCurrentDateWithFormat();
//        trimAndSplit();
//        lengthAndSize();
//        writeFile();
//        generateTreeDir();

    }

    private static void stream() throws IOException {
        StreamTesting st = new StreamTesting();
        st.printForEach();
    }

    private static void textContains() {
        StringTestingClass stc = new StringTestingClass();
        String input = "order(acceptance_decision_date=2022-02-23t11:06:29z, can_cancel=false, can_evaluate=false, can_shop_ship=false, channel=null, commercial_id=60280441, created_date=2022-02-23t11:04:45z, currency_iso_code=null, customer=customer(billing_address=billingaddress(city=seminar alcobendas, company=null, country=spain, country_iso_code=null, firstname=pass, lastname=user, phone=658947123, state=madrid, street_1=calle test, street_2=, zip_code=28100), civility=null, customer_id=mya0bb9ed0, email=passr10@mailinator.com, firstname=pass, lastname=user, locale=null, shipping_address=shippingaddress(additional_info=null, city=seminario alcobendas, company=null, country=spain, country_iso_code=null, firstname=pass, internal_additional_info=null, lastname=user, phone=658947123, state=madrid, street_1=calle test, street_2=, zip_code=28100)), customer_debited_date=null, delivery_date=null, fulfillment=null, has_customer_message=false, has_incident=false, has_invoice=false, last_updated_date=2022-02-23t11:06:41z, leadtime_to_ship=0, order_additional_fields=null, order_id=60280441-a, order_lines=[orderline(can_open_incident=true, =true, cancelations=null, category_code=cpim-46102, category_label=4․electro_pae_hogar_aire acondicionado, commission_fee=3.7, commission_rate_vat=0.0, commission_taxes=null, commission_vat=0.0, created_date=2022-02-23t11:04:45z, debited_date=2022-02-23t11:06:41z, description=null, last_updated_date=2022-02-23t11:06:41z, offer_id=987955, offer_sku=7000000000030, offer_state_code=11, order_line_additional_fields=[], order_line_id=60280441-a-1, order_line_index=1, order_line_state=shipping, order_line_state_reason_code=null, order_line_state_reason_label=null, price=66.0, price_additional_info=null, price_unit=66.0, product_medias=null, product_sku=7000000000030, product_title=nuevo cambio pruebas sincro again mmv, promotions=null, quantity=1, received_date=null, refunds=null, shipped_date=null, shipping_price=8.0, shipping_price_additional_unit=null, shipping_price_unit=null, shipping_taxes=null, taxes=null, total_commission=3.7, total_price=74.0)], refunds=null, order_state=shipping, order_state_reason_code=null, order_state_reason_label=null, order_tax_mode=null, paymenttype=visasecured/mastercardsecured, payment_type=visasecured/mastercardsecured, payment_workflow=null, price=66.0, promotions=null, quote_id=null, shipping_carrier_code=null, shipping_company=null, shipping_deadline=null, shipping_price=8.0, shipping_pudo_id=null, shipping_tracking=null, shipping_tracking_url=null, shipping_type_code=ordinario/3-5 días, shipping_type_label=ordinario/3-5 días, shipping_zone_code=pluspeninsula, shipping_zone_label=zona 1 peninsula, shop_id=2017, shop_name=galaxysaurio, total_commission=3.7, total_price=74.0, transaction_date=null, waiting_tax_confirmation=false)";
        String contains = "refund";
        stc.textContains(input, contains);
    }

    private static void substringThis() {
        StringTestingClass stc = new StringTestingClass();
        System.out.println(stc.substring("Tarjeta PASS Fin10M"));
    }

    private static void doubleToString() {
        DoubleToString dts = new DoubleToString();
        System.out.println(dts.doubleToString(20.3));
    }

    public static void getCurrentDateWithFormat() {
        Dates date = new Dates();
        System.out.println(date.getCurrentDateWithFormat());
    }

    private static void generateTreeDir() {
        DirTree dt = new DirTree();
        dt.generateTreeDir("uno/dos/tres/cuatro");
    }

    private static void writeFile() throws IOException {
        WritingFiles w = new WritingFiles();
        w.writeFileWithExistingText();
    }

    public static void lengthAndSize() {
        LengthAndSize ls = new LengthAndSize();
        ls.SizeAndLength();

    }

    public static void trimAndSplit() {
        String input = "12345678";
        String input2 = "aAbBcC A";

        StringTestingClass s = new StringTestingClass();

        // Trim
        System.out.println("Split 1 -> " + s.splitInput(input));
        System.out.println("Split 2 -> " + s.splitInput(input2));

        //Split
        System.out.println("Trim 1 -> " + s.trimInput(input));
        System.out.printf("Trim 2 -> %s\n", s.trimInput(input2));
        System.out.printf("Trim 3 -> %S\n", s.trimInput(input2));
    }

}
