//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2020.08.19 às 09:41:28 PM BRT 
//


package com.mercadolivre.morseresource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="morseResult" type="{http://mercadolivre.com/morseResource}Result" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "morseResult"
})
@XmlRootElement(name = "MorseBitsResponse")
public class MorseBitsResponse {

    protected Result morseResult;

    /**
     * Obtém o valor da propriedade morseResult.
     * 
     * @return
     *     possible object is
     *     {@link Result }
     *     
     */
    public Result getMorseResult() {
        return morseResult;
    }

    /**
     * Define o valor da propriedade morseResult.
     * 
     * @param value
     *     allowed object is
     *     {@link Result }
     *     
     */
    public void setMorseResult(Result value) {
        this.morseResult = value;
    }

}
