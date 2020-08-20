//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2020.08.19 às 09:41:28 PM BRT 
//


package com.mercadolivre.morseresource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de MorseHuman complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="MorseHuman">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="translate2Human" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MorseHuman", propOrder = {
    "translate2Human"
})
public class MorseHuman {

    @XmlElement(required = true)
    protected String translate2Human;

    /**
     * Obtém o valor da propriedade translate2Human.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTranslate2Human() {
        return translate2Human;
    }

    /**
     * Define o valor da propriedade translate2Human.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTranslate2Human(String value) {
        this.translate2Human = value;
    }

}
