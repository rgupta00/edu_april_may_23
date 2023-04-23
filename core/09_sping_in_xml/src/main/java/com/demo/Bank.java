package com.demo;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Bank {
	private String bankName;
	private List<Account> accounts;

	//map (if any key or value is not string u can not use props u must use map
	private Map<String, BranchLocation> branches;

	//props: BN --> Manager (both must be string ) Map
	private Map<String, String> branchManagers;

	public void setBranchManagers(Map<String, String> branchManagers) {
		this.branchManagers = branchManagers;
	}

	public void setBranches(Map<String, BranchLocation> branches) {
		this.branches = branches;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public void print(){
		System.out.println("bankname : "+ bankName);
		System.out.println("all accounts of the bank");

		accounts.forEach(a-> System.out.println(a));

		System.out.println("all branches infor");

		branches.forEach((k, v)-> System.out.println(k+": "+ v));

		branchManagers.forEach((k, v)-> System.out.println(k+": "+ v));
	}
}













