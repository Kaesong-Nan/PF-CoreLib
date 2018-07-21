package cn.mgazul.pfcorelib;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

public class MgEco implements Economy{

	public EconomyResponse bankBalance(String arg0) {
		// TODO 自动生成的方法存根
		return null;
	}

	public EconomyResponse bankDeposit(String arg0, double arg1) {
		// TODO 自动生成的方法存根
		return null;
	}

	public EconomyResponse bankHas(String arg0, double arg1) {
		// TODO 自动生成的方法存根
		return null;
	}

	public EconomyResponse bankWithdraw(String arg0, double arg1) {
		// TODO 自动生成的方法存根
		return null;
	}

	public EconomyResponse createBank(String arg0, String arg1) {
		// TODO 自动生成的方法存根
		return null;
	}


	public EconomyResponse createBank(String arg0, OfflinePlayer arg1) {
		// TODO 自动生成的方法存根
		return null;
	}


	public boolean createPlayerAccount(String arg0) {
		// TODO 自动生成的方法存根
		return false;
	}


	public boolean createPlayerAccount(OfflinePlayer arg0) {
		// TODO 自动生成的方法存根
		return false;
	}


	public boolean createPlayerAccount(String arg0, String arg1) {
		// TODO 自动生成的方法存根
		return false;
	}


	public boolean createPlayerAccount(OfflinePlayer arg0, String arg1) {
		// TODO 自动生成的方法存根
		return false;
	}


	public String currencyNamePlural() {
		// TODO 自动生成的方法存根
		return "铜钱";
	}


	public String currencyNameSingular() {
		// TODO 自动生成的方法存根
		return "铜钱";
	}


	public EconomyResponse deleteBank(String arg0) {
		// TODO 自动生成的方法存根
		return null;
	}


	public EconomyResponse depositPlayer(String arg0, double arg1) {
		// TODO 自动生成的方法存根
	    if (arg1 > 0.0D){
	    	Player p = Bukkit.getPlayer(arg0);
	      if (p == null) {
	        return new EconomyResponse(0.0D, 0.0D, EconomyResponse.ResponseType.FAILURE, "§c账户不存在");
	      }
	      MoneyAPI.setMoneys(arg0, getBalance(arg0)+arg1);
	      return new EconomyResponse(0.0D, getBalance(arg0), EconomyResponse.ResponseType.SUCCESS, "");
	    }
	    return new EconomyResponse(0.0D, 0.0D, EconomyResponse.ResponseType.FAILURE, "§c剩余铜钱为负值");
	  }


	public EconomyResponse depositPlayer(OfflinePlayer arg0, double arg1) {
		// TODO 自动生成的方法存根
		return depositPlayer(arg0.getName(), arg1);
	}


	public EconomyResponse depositPlayer(String arg0, String arg1, double arg2) {
		// TODO 自动生成的方法存根
		return depositPlayer(arg0, arg2);
	}


	public EconomyResponse depositPlayer(OfflinePlayer arg0, String arg1, double arg2) {
		// TODO 自动生成的方法存根
		return depositPlayer(arg0.getName(), arg2);
	}


	public String format(double arg0) {
		// TODO 自动生成的方法存根
	    boolean isWholeNumber = arg0 == Math.round(arg0);
	    
	    DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
	    
	    formatSymbols.setDecimalSeparator('.');
	    
	    String pattern = isWholeNumber ? "###,###.###" : "###,##0.00";
	    
	    DecimalFormat df = new DecimalFormat(pattern, formatSymbols);
	    
	    return df.format(arg0);
	}


	public int fractionalDigits() {
		// TODO 自动生成的方法存根
		return -1;
	}


	public double getBalance(String arg0) {
		// TODO 自动生成的方法存根
		return MoneyAPI.getMoneys(arg0);
	}


	public double getBalance(OfflinePlayer arg0) {
		// TODO 自动生成的方法存根
		return MoneyAPI.getMoneys(arg0.getName());
	}


	public double getBalance(String arg0, String arg1) {
		// TODO 自动生成的方法存根
		return MoneyAPI.getMoneys(arg0);
	}


	public double getBalance(OfflinePlayer arg0, String arg1) {
		// TODO 自动生成的方法存根
		return MoneyAPI.getMoneys(arg0.getName());
	}


	public List<String> getBanks() {
		// TODO 自动生成的方法存根
		return new ArrayList<String>();
	}


	public String getName() {
		// TODO 自动生成的方法存根
		return "PFEco";
	}


	public boolean has(String arg0, double arg1) {
		 double balance = getBalance(arg0);
	    if (balance >= arg1) {
	        return true;
	      }
	      return false;
	    }


	public boolean has(OfflinePlayer arg0, double arg1) {
		// TODO 自动生成的方法存根
		return has(arg0.getName(), arg1);
	}


	public boolean has(String arg0, String arg1, double arg2) {
		// TODO 自动生成的方法存根
		return has(arg0, arg2);
	}


	public boolean has(OfflinePlayer arg0, String arg1, double arg2) {
		// TODO 自动生成的方法存根
		return has(arg0.getName(), arg2);
	}


	public boolean hasAccount(String arg0) {
		// TODO 自动生成的方法存根
		return MoneyAPI.getMoneys(arg0)!=null;
	}


	public boolean hasAccount(OfflinePlayer arg0) {
		// TODO 自动生成的方法存根
		return hasAccount(arg0.getName());
	}


	public boolean hasAccount(String arg0, String arg1) {
		// TODO 自动生成的方法存根
		return hasAccount(arg0);
	}


	public boolean hasAccount(OfflinePlayer arg0, String arg1) {
		// TODO 自动生成的方法存根
		return hasAccount(arg0.getName());
	}


	public boolean hasBankSupport() {
		// TODO 自动生成的方法存根
		return false;
	}


	public EconomyResponse isBankMember(String arg0, String arg1) {
		// TODO 自动生成的方法存根
		return null;
	}


	public EconomyResponse isBankMember(String arg0, OfflinePlayer arg1) {
		// TODO 自动生成的方法存根
		return null;
	}


	public EconomyResponse isBankOwner(String arg0, String arg1) {
		// TODO 自动生成的方法存根
		return null;
	}


	public EconomyResponse isBankOwner(String arg0, OfflinePlayer arg1) {
		// TODO 自动生成的方法存根
		return null;
	}


	public boolean isEnabled() {
		// TODO 自动生成的方法存根
		return Main.plugin.isEnabled();
	}


	public EconomyResponse withdrawPlayer(String arg0, double arg1) {
		// TODO 自动生成的方法存根
		Player p = Bukkit.getPlayer(arg0);
	    if (p == null) {
	      return new EconomyResponse(0.0D, 0.0D, EconomyResponse.ResponseType.FAILURE, "§c账户不存在");
	    }
	    if (arg1 < 0.0D) {
	      return new EconomyResponse(0.0D, 0.0D, EconomyResponse.ResponseType.FAILURE, "§c剩余铜钱为负值");
	    }
	    MoneyAPI.setMoneys(arg0, getBalance(arg0)-arg1);
	    return new EconomyResponse(0.0D, getBalance(arg0), EconomyResponse.ResponseType.SUCCESS, "");
	  }


	public EconomyResponse withdrawPlayer(OfflinePlayer arg0, double arg1) {
		// TODO 自动生成的方法存根
		return withdrawPlayer(arg0.getName(), arg1);
	}


	public EconomyResponse withdrawPlayer(String arg0, String arg1, double arg2) {
		// TODO 自动生成的方法存根
		return withdrawPlayer(arg0, arg2);
	}


	public EconomyResponse withdrawPlayer(OfflinePlayer arg0, String arg1, double arg2) {
		// TODO 自动生成的方法存根
		return withdrawPlayer(arg0.getName(), arg2);
	}

}
