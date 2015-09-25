package edu.bietdvg.davana.vtufest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class AlertDialogManager {

	public void ShowAlertBox(Context context, String title, String message,
			String bPossitive) {

		AlertDialog alertdialog = new AlertDialog.Builder(context).create();
		alertdialog.setTitle(title);
		alertdialog.setMessage(message);
		alertdialog.setButton(AlertDialog.BUTTON_POSITIVE, bPossitive,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub

					}
				});
		alertdialog.show();

	}

}
