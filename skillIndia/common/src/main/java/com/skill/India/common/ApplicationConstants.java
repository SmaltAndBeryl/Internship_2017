/**
 * 
 */
package com.skill.India.common;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author Ashish Mishra
 *
 */
@EnableAutoConfiguration
@EnableConfigurationProperties
public abstract class ApplicationConstants {

	public static String errorComment; 
	
	public static String successComment;
	
	//public static String trainingPartnerPastbatchesKey;
	
	//public static String trainingPartnerPresentBatchesKey;
}
