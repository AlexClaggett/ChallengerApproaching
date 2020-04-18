package com.example.challengerapproaching.utils;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.example.challengerapproaching.R;
import java.util.Calendar;

/**********************************************************************
 * Event Dialog Class. This Handles opening a dialog new dialog that
 * acts as the hub for entering in information about events. Allows
 * the user to enter an event name, and select a date from a date
 * picker.
 *********************************************************************/
public class EventDialog extends AppCompatDialogFragment {

  /** Edit Text View That holds the Name of the Event being created. */
  private transient EditText editTextEventName;

  /** Text View that holds the contents of the Event date. */
  private transient TextView textEventDate;

  /** Event Dialog Listener that waits for the user to select a date.*/
  private transient EventDialogListener listener;

  /** OnDateSetListener that Is used to set the date. */
  private transient DatePickerDialog.OnDateSetListener onDateSetListener;

  /** Calendar for holding the new given date. */
  public transient Calendar newDate;

  /********************************************************************
   * onCreate method for Dialog uses a builder to create the view and
   * populate the inside of the dialog. Handles the logic for
   * everything inside the dialog box.
   * @param savedInstance saved instance required for onCreate.
   * @return Dialog that can be used for creating an Event.
   *******************************************************************/
  @NonNull
  @Override
  public Dialog onCreateDialog(final @Nullable Bundle savedInstance) {
    /* Inflater for populating the layout with views. */
    final LayoutInflater inflater = getActivity().getLayoutInflater();

    /* View to add to the inflater. */
    final View view = inflater.inflate(R.layout.layout_eventcreation, null);

    /* Initialize the Event name Edit Text View to the correct view. */
    editTextEventName = view.findViewById(R.id.edit_eventname);

    /* Initialize the Event date Text View to the correct View. */
    textEventDate = view.findViewById(R.id.edit_eventDate);

    /* Initialize newDate to the current calendar date. */
    newDate = Calendar.getInstance();

    /* Builder for creating the dialog within the current activity. */
    final AlertDialog.Builder builder =
        new AlertDialog.Builder(getActivity());

    // Defines what happens when eventSetup is selected.
    textEventDate.setOnClickListener(v -> {
      // Create calendar object equal to today's date.
      final Calendar cal = Calendar.getInstance();

      // Create year int to hold the calendar year.
      final int year = cal.get(Calendar.YEAR);

      // Create month int to hold the calendar month.
      final int month = cal.get(Calendar.MONTH);

      // Create day int to hold the calendar day.
      final int day = cal.get(Calendar.DAY_OF_MONTH);

      //Create DatePickerDialog object and initializes it.
      final DatePickerDialog dialog = new DatePickerDialog(
          this.getActivity(),
          android.R.style.Theme_Holo_Dialog_MinWidth,
          onDateSetListener, year, month, day);
      // Set the windows background
      dialog.getWindow().setBackgroundDrawable(
          new ColorDrawable(Color.TRANSPARENT));

      // Tell the system to show the DatePickerDialog on click.
      dialog.show();
    });

    // Initialize the onDateSetListener to a date picker dialog.
    onDateSetListener = new DatePickerDialog.OnDateSetListener() {
      /***************************************************************
       * Class that defines what happens once a date is selected.
       *
       * @param view the datePicker view
       * @param year the year selected.
       * @param month the month selected
       * @param dayOfMonth the day of the month selected
       ***************************************************************/
      @Override
      public void onDateSet(final DatePicker view, final int year, int month,
                            final int dayOfMonth) {
        // Adds one to the month because the calendar starts at 0.
        month = month + 1;
        String date = "";
        date += month + "/";
        date += dayOfMonth + "/";
        date += year;
        newDate.set(year,month,dayOfMonth);
        textEventDate.setText(date);
      }
    };

    // Sets the view's within the builder, and details it's options.
    builder.setView(view)
        // Set the Title for the dialog box.
        .setTitle("Event Creation")

        // Add logic for cancel button to close on click.
        .setNegativeButton("cancel", (dialog, which) -> {

        })

        // Add logic for the Create button on click.
        .setPositiveButton("Create", (dialog, which) -> {

          // Set the event name once created.
          final String eventName =
              editTextEventName.getText().toString();

          // Set the event date once created.
          final String eventDate =
              textEventDate.getText().toString();

          // Log to check date is correct.
          Log.d("EventDialog","New Date is: "
              + newDate.getTime());

          // Call apply text inside EventActivity.
          // Sets date and name.
          listener.applyText(eventName, eventDate);
        });

    // Return and create builder.
    return builder.create();
  }

  /********************************************************************
   * onAttach method for attaching dialog to the correct context.
   * @param context where the dialog is being called.
   *******************************************************************/
  @Override
  public void onAttach(final @NonNull Context context) {
    super.onAttach(context);

    try {
      listener = (EventDialogListener) context;
    } catch (ClassCastException e) {
      throw new ClassCastException(context.toString()
          + "Must implement EventDialog Listener");
    }
  }

  /********************************************************************
   * Interface for detailing anything calling dialog needs a applytext
   * method to properly apply the event.
   *******************************************************************/
  public interface EventDialogListener {

    /**applies text*/
    void applyText(String eventName, String date);
  }
}



