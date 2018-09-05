package com.thecat.databaseService.entities;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Simple object representing a Product, use as a representation of a DB entry.
 *
 * @author froberge
 * @since September 2018
 */

@XmlRootElement
public class Product {

	private String id;
	private String name;
	private String category;
	private String subCategory_1;
	private String subCategory_2;
	private String price;

	/**
	 * @return {@link String}
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id {@link String}
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return {@link String}
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name {@link String}
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return {@link String}
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category {@link String}
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return {@link String}
	 */
	public String getSubCategory_1() {
		return subCategory_1;
	}

	/**
	 * @param subCategory_1 {@link String}
	 */
	public void setSubCategory_1(String subCategory_1) {
		this.subCategory_1 = subCategory_1;
	}

	/**
	 * @return {@link String}
	 */
	public String getSubCategory_2() {
		return subCategory_2;
	}

	/**
	 * @param subCategory_2 {@link String}
	 */
	public void setSubCategory_2(String subCategory_2) {
		this.subCategory_2 = subCategory_2;
	}

	/**
	 * @return {@link String}
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price {@link String}
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	public String toString() {

		StringBuffer sb = new StringBuffer( "Information on the product: \n" );

		sb.append("id [ " + this.id + "]\n");
		sb.append("name [ " + this.name + "]\n");
		sb.append("category [ " + this.category + "]\n");
		sb.append("Sub Category 1 [ " + this.subCategory_1 + "]\n");
		sb.append("Sub Category 2 [ " + this.subCategory_2 + "]\n");
		sb.append("Price [ " + this.price + "]\n");

		return sb.toString();
	}

}
