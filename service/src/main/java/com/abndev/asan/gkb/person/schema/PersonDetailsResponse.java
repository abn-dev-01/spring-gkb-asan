//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.02.02 at 06:58:13 PM MSK 
//


package com.abndev.asan.gkb.person.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Person" type="{http://bip.bee.kz/SyncChannel/v10/Types/Response}SyncSendMessageResponse"/&gt;
 *         &lt;element name="gbdBillingResponse" type="{http://bip.bee.kz/SyncChannel/v10/Types}GbdBillingResponse"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "person",
    "gbdBillingResponse"
})
@XmlRootElement(name = "PersonDetailsResponse", namespace = "http://gbd.chdb.scb.kz/xml/person")
public class PersonDetailsResponse {

    @XmlElement(name = "Person", namespace = "http://gbd.chdb.scb.kz/xml/person", required = true)
    protected SyncSendMessageResponse person;
    @XmlElement(namespace = "http://gbd.chdb.scb.kz/xml/person", required = true)
    protected GbdBillingResponse gbdBillingResponse;

    /**
     * Gets the value of the person property.
     * 
     * @return
     *     possible object is
     *     {@link SyncSendMessageResponse }
     *     
     */
    public SyncSendMessageResponse getPerson() {
        return person;
    }

    /**
     * Sets the value of the person property.
     * 
     * @param value
     *     allowed object is
     *     {@link SyncSendMessageResponse }
     *     
     */
    public void setPerson(SyncSendMessageResponse value) {
        this.person = value;
    }

    /**
     * Gets the value of the gbdBillingResponse property.
     * 
     * @return
     *     possible object is
     *     {@link GbdBillingResponse }
     *     
     */
    public GbdBillingResponse getGbdBillingResponse() {
        return gbdBillingResponse;
    }

    /**
     * Sets the value of the gbdBillingResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link GbdBillingResponse }
     *     
     */
    public void setGbdBillingResponse(GbdBillingResponse value) {
        this.gbdBillingResponse = value;
    }

}
