# Introduction to garde-manger

TODO: write [great documentation](http://jacobian.org/writing/what-to-write/)

The purpose of garde-manger is to examine the contents of repositories external to ClinGen and input changes into the data pipeline.

## Data to include

* Dosage Sensitivity
* ClinVar

Other sources should push data directly into the exchange.

## Procedure

* Parse data source (ideally starting from a point in time, possible for gene dosage, probably not possible for ClinVar)
* Analyze for deltas from previous breakpoint.
  * For ClinVar, this should be possible by scanning records for a 'date changed' after the last import.
* Transform changed or new records into the data model.
* Push transformed records into the data exchange.
